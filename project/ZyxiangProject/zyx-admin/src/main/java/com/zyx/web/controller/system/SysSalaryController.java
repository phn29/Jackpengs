package com.zyx.web.controller.system;

import java.util.List;

import com.zyx.common.core.domain.entity.SysSalary;
import com.zyx.system.service.ISysMajorService;
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
import com.zyx.system.service.ISysSalaryService;
import com.zyx.common.core.controller.BaseController;
import com.zyx.common.core.domain.AjaxResult;
import com.zyx.common.utils.poi.ExcelUtil;
import com.zyx.common.core.page.TableDataInfo;

/**
 * 专业薪资列表Controller
 *
 * @author 张银祥
 * @date 2021-07-13
 */
@Controller
@RequestMapping("/system/salary")
public class SysSalaryController extends BaseController
{
    private String prefix = "system/salary";

    @Autowired
    private ISysSalaryService sysSalaryService;
    @Autowired
    private ISysMajorService majorService;

    @RequiresPermissions("system:salary:view")
    @GetMapping()
    public String salary(ModelMap mmap)
    {
        mmap.put("majors", majorService.selectSysMajorAll());
        return prefix + "/salary";
    }

    /**
     * 查询专业薪资列表列表
     */
    @RequiresPermissions("system:salary:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysSalary sysSalary)
    {
        startPage();
        List<SysSalary> list = sysSalaryService.selectSysSalaryList(sysSalary);
        return getDataTable(list);
    }

    /**
     * 导出专业薪资列表列表
     */
    @RequiresPermissions("system:salary:export")
    @Log(title = "专业薪资列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysSalary sysSalary)
    {
        List<SysSalary> list = sysSalaryService.selectSysSalaryList(sysSalary);
        ExcelUtil<SysSalary> util = new ExcelUtil<SysSalary>(SysSalary.class);
        return util.exportExcel(list, "专业薪资列表数据");
    }

    /**
     * 新增专业薪资列表
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("majors", majorService.selectSysMajorAll());
        return prefix + "/add";
    }

    /**
     * 新增保存专业薪资列表
     */
    @RequiresPermissions("system:salary:add")
    @Log(title = "专业薪资列表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysSalary sysSalary)
    {
        return toAjax(sysSalaryService.insertSysSalary(sysSalary));
    }

    /**
     * 修改专业薪资列表
     */
    @GetMapping("/edit/{salaryId}")
    public String edit(@PathVariable("salaryId") Long salaryId, ModelMap mmap)
    {
        SysSalary sysSalary = sysSalaryService.selectSysSalaryById(salaryId);
        mmap.put("sysSalary", sysSalary);
        mmap.put("majors", majorService.selectSysMajorAll());
        return prefix + "/edit";
    }

    /**
     * 修改保存专业薪资列表
     */
    @RequiresPermissions("system:salary:edit")
    @Log(title = "专业薪资列表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysSalary sysSalary)
    {
        return toAjax(sysSalaryService.updateSysSalary(sysSalary));
    }

    /**
     * 删除专业薪资列表
     */
    @RequiresPermissions("system:salary:remove")
    @Log(title = "专业薪资列表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysSalaryService.deleteSysSalaryByIds(ids));
    }
}