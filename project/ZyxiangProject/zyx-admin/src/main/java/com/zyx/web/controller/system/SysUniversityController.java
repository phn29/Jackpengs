package com.zyx.web.controller.system;

import com.zyx.common.annotation.Log;
import com.zyx.common.core.controller.BaseController;
import com.zyx.common.core.domain.AjaxResult;
import com.zyx.common.core.domain.entity.SysUniversity;
import com.zyx.common.core.page.TableDataInfo;
import com.zyx.common.enums.BusinessType;
import com.zyx.common.utils.ShiroUtils;
import com.zyx.common.utils.poi.ExcelUtil;
import com.zyx.system.service.ISysUniversityService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

/**
 * 院校管理Controller
 *
 * @author 张银祥
 * @date 2021-05-26
 */
@Controller
@RequestMapping("/system/university")
public class SysUniversityController extends BaseController
{
    private String prefix = "system/university";

    @Autowired
    private ISysUniversityService sysUniversityService;

    @RequiresPermissions("system:university:view")
    @GetMapping()
    public String university(ModelMap mmap)
    {
        mmap.put("universitys", sysUniversityService.selectSysUniversityAll());
        return prefix + "/university";
    }

    /**
     * 查询院校管理列表
     */
    @RequiresPermissions("system:university:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysUniversity sysUniversity)
    {
        startPage();
        List<SysUniversity> list = sysUniversityService.selectSysUniversityList(sysUniversity);
        return getDataTable(list);
    }

    /**
     * 导出院校管理列表
     */
    @RequiresPermissions("system:university:export")
    @Log(title = "院校管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysUniversity sysUniversity)
    {
        List<SysUniversity> list = sysUniversityService.selectSysUniversityList(sysUniversity);
        ExcelUtil<SysUniversity> util = new ExcelUtil<SysUniversity>(SysUniversity.class);
        return util.exportExcel(list, "院校管理数据");
    }

    /**
     * 导入专业表列表
     */
    @Log(title = "专业表", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:university:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<SysUniversity> util = new ExcelUtil<>(SysUniversity.class);
        List<SysUniversity> universityList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = sysUniversityService.importUniversity(universityList, updateSupport, operName);
        return AjaxResult.success(message);
    }
    @RequiresPermissions("system:university:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<SysUniversity> util = new ExcelUtil<>(SysUniversity.class);
        return util.importTemplateExcel("专业数据");
    }

    /**
     * 新增院校管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存院校管理
     */
    @RequiresPermissions("system:university:add")
    @Log(title = "院校管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysUniversity sysUniversity)
    {
        return toAjax(sysUniversityService.insertSysUniversity(sysUniversity));
    }

    /**
     * 修改院校管理
     */
    @GetMapping("/edit/{universityId}")
    public String edit(@PathVariable("universityId") Long universityId, ModelMap mmap)
    {
        SysUniversity sysUniversity = sysUniversityService.selectSysUniversityById(universityId);
        mmap.put("sysUniversity", sysUniversity);
        return prefix + "/edit";
    }

    /**
     * 修改保存院校管理
     */
    @RequiresPermissions("system:university:edit")
    @Log(title = "院校管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysUniversity sysUniversity)
    {
        return toAjax(sysUniversityService.updateSysUniversity(sysUniversity));
    }

    /**
     * 删除院校管理
     */
    @RequiresPermissions("system:university:remove")
    @Log(title = "院校管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysUniversityService.deleteSysUniversityByIds(ids));
    }
}
