package com.zyx.web.controller.system;

import com.zyx.common.core.domain.entity.SysPlan;
import com.zyx.common.utils.ShiroUtils;
import com.zyx.system.service.ISysMajorService;
import com.zyx.system.service.ISysUniversityService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zyx.common.annotation.Log;
import com.zyx.common.enums.BusinessType;
import com.zyx.system.service.ISysPlanService;
import com.zyx.common.core.controller.BaseController;
import com.zyx.common.core.domain.AjaxResult;
import com.zyx.common.utils.poi.ExcelUtil;
import com.zyx.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 计划招生表Controller
 *
 * @author 张银祥
 * @date 2021-06-15
 */
@Controller
@RequestMapping("/system/plan")
public class SysPlanController extends BaseController
{
    private String prefix = "system/plan";

    @Autowired
    private ISysPlanService sysPlanService;
    @Autowired
    private ISysUniversityService universityService;
    @Autowired
    private ISysMajorService majorService;


    @RequiresPermissions("system:plan:view")
    @GetMapping()
    public String plan(ModelMap mmap)
    {
        mmap.put("universitys", universityService.selectSysUniversityAll());
        mmap.put("majors", majorService.selectSysMajorAll());
        return prefix + "/plan";
    }

    /**
     * 查询计划招生表列表
     */
    @RequiresPermissions("system:plan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysPlan sysPlan)
    {
        startPage();
        List<SysPlan> list = sysPlanService.selectSysPlanList(sysPlan);
        return getDataTable(list);
    }

    /**
     * 导出计划招生表列表
     */
    @RequiresPermissions("system:plan:export")
    @Log(title = "计划招生表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysPlan sysPlan)
    {
        List<SysPlan> list = sysPlanService.selectSysPlanList(sysPlan);
        ExcelUtil<SysPlan> util = new ExcelUtil<SysPlan>(SysPlan.class);
        return util.exportExcel(list, "计划招生表数据");
    }

    /**
     * 导入专业表列表
     */
    @Log(title = "招生计划表", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:plan:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<SysPlan> util = new ExcelUtil<SysPlan>(SysPlan.class);
        List<SysPlan> planList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = sysPlanService.importPlan(planList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("system:plan:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<SysPlan> util = new ExcelUtil<SysPlan>(SysPlan.class);
        return util.importTemplateExcel("招生计划数据");
    }


    /**
     * 新增计划招生表
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("universitys", universityService.selectSysUniversityAll());
        mmap.put("majors", majorService.selectSysMajorAll());
        return prefix + "/add";
    }

    /**
     * 新增保存计划招生表
     */
    @RequiresPermissions("system:plan:add")
    @Log(title = "计划招生表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysPlan sysPlan)
    {
        return toAjax(sysPlanService.insertSysPlan(sysPlan));
    }

    /**
     * 修改计划招生表
     */
    @GetMapping("/edit/{planId}")
    public String edit(@PathVariable("planId") Long planId, ModelMap mmap)
    {
        SysPlan sysPlan = sysPlanService.selectSysPlanById(planId);
        mmap.put("sysPlan", sysPlan);
        mmap.put("universitys", universityService.selectSysUniversityAll());
        mmap.put("majors", majorService.selectSysMajorAll());
        return prefix + "/edit";
    }

    /**
     * 修改保存计划招生表
     */
    @RequiresPermissions("system:plan:edit")
    @Log(title = "计划招生表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysPlan sysPlan)
    {
        return toAjax(sysPlanService.updateSysPlan(sysPlan));
    }

    /**
     * 删除计划招生表
     */
    @RequiresPermissions("system:plan:remove")
    @Log(title = "计划招生表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysPlanService.deleteSysPlanByIds(ids));
    }
}
