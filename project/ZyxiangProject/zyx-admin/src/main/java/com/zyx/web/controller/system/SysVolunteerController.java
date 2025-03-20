package com.zyx.system.controller;

import java.util.List;

import com.zyx.common.core.domain.entity.SysVolunteer;
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
import com.zyx.system.service.ISysVolunteerService;
import com.zyx.common.core.controller.BaseController;
import com.zyx.common.core.domain.AjaxResult;
import com.zyx.common.utils.poi.ExcelUtil;
import com.zyx.common.core.page.TableDataInfo;

/**
 * 考生志愿表Controller
 *
 * @author 张银祥
 * @date 2021-08-17
 */
@Controller
@RequestMapping("/system/volunteer")
public class SysVolunteerController extends BaseController
{
    private String prefix = "system/volunteer";

    @Autowired
    private ISysVolunteerService sysVolunteerService;

    @RequiresPermissions("system:volunteer:view")
    @GetMapping()
    public String volunteer()
    {
        return prefix + "/volunteer";
    }

    /**
     * 查询考生志愿表列表
     */
    @RequiresPermissions("system:volunteer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysVolunteer sysVolunteer)
    {
        startPage();
        List<SysVolunteer> list = sysVolunteerService.selectSysVolunteerList(sysVolunteer);
        return getDataTable(list);
    }

    /**
     * 导出考生志愿表列表
     */
    @RequiresPermissions("system:volunteer:export")
    @Log(title = "考生志愿表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysVolunteer sysVolunteer)
    {
        List<SysVolunteer> list = sysVolunteerService.selectSysVolunteerList(sysVolunteer);
        ExcelUtil<SysVolunteer> util = new ExcelUtil<SysVolunteer>(SysVolunteer.class);
        return util.exportExcel(list, "考生志愿表数据");
    }

    /**
     * 新增考生志愿表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存考生志愿表
     */
    @RequiresPermissions("system:volunteer:add")
    @Log(title = "考生志愿表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysVolunteer sysVolunteer)
    {
        return toAjax(sysVolunteerService.insertSysVolunteer(sysVolunteer));
    }

    /**
     * 修改考生志愿表
     */
    @GetMapping("/edit/{volunteerId}")
    public String edit(@PathVariable("volunteerId") Long volunteerId, ModelMap mmap)
    {
        SysVolunteer sysVolunteer = sysVolunteerService.selectSysVolunteerById(volunteerId);
        mmap.put("sysVolunteer", sysVolunteer);
        return prefix + "/edit";
    }

    /**
     * 修改保存考生志愿表
     */
    @RequiresPermissions("system:volunteer:edit")
    @Log(title = "考生志愿表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysVolunteer sysVolunteer)
    {
        return toAjax(sysVolunteerService.updateSysVolunteer(sysVolunteer));
    }

    /**
     * 删除考生志愿表
     */
    @RequiresPermissions("system:volunteer:remove")
    @Log(title = "考生志愿表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysVolunteerService.deleteSysVolunteerByIds(ids));
    }
}