package com.zyx.web.controller.system;

import com.zyx.common.annotation.Log;
import com.zyx.common.core.controller.BaseController;
import com.zyx.common.core.domain.AjaxResult;
import com.zyx.common.core.domain.entity.SysExpert;
import com.zyx.common.core.page.TableDataInfo;
import com.zyx.common.enums.BusinessType;
import com.zyx.common.utils.poi.ExcelUtil;
import com.zyx.system.service.ISysExpertService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 专家表Controller
 *
 * @author zyx
 * @date 2022-02-08
 */
@Controller
@RequestMapping("/system/expert")
public class SysExpertController extends BaseController
{
    private String prefix = "system/expert";

    @Autowired
    private ISysExpertService sysExpertService;

    @RequiresPermissions("system:expert:view")
    @GetMapping()
    public String expert()
    {
        return prefix + "/expert";
    }

    /**
     * 查询专家表列表
     */
    @RequiresPermissions("system:expert:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysExpert sysExpert)
    {
        startPage();
        List<SysExpert> list = sysExpertService.selectSysExpertList(sysExpert);
        return getDataTable(list);
    }

    /**
     * 导出专家表列表
     */
    @RequiresPermissions("system:expert:export")
    @Log(title = "专家表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysExpert sysExpert)
    {
        List<SysExpert> list = sysExpertService.selectSysExpertList(sysExpert);
        ExcelUtil<SysExpert> util = new ExcelUtil<SysExpert>(SysExpert.class);
        return util.exportExcel(list, "专家表数据");
    }

    /**
     * 新增专家表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存专家表
     */
    @RequiresPermissions("system:expert:add")
    @Log(title = "专家表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysExpert sysExpert)
    {
        return toAjax(sysExpertService.insertSysExpert(sysExpert));
    }

    /**
     * 修改专家表
     */
    @GetMapping("/edit/{expertId}")
    public String edit(@PathVariable("expertId") Long expertId, ModelMap mmap)
    {
        SysExpert sysExpert = sysExpertService.selectSysExpertById(expertId);
        mmap.put("sysExpert", sysExpert);
        return prefix + "/edit";
    }

    /**
     * 修改保存专家表
     */
    @RequiresPermissions("system:expert:edit")
    @Log(title = "专家表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysExpert sysExpert)
    {
        return toAjax(sysExpertService.updateSysExpert(sysExpert));
    }

    /**
     * 删除专家表
     */
    @RequiresPermissions("system:expert:remove")
    @Log(title = "专家表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysExpertService.deleteSysExpertByIds(ids));
    }
}
