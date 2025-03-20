package com.zyx.web.controller.system;

import java.util.List;

import com.zyx.common.core.domain.entity.SysHistory;
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
import com.zyx.system.service.ISysHistoryService;
import com.zyx.common.core.controller.BaseController;
import com.zyx.common.core.domain.AjaxResult;
import com.zyx.common.utils.poi.ExcelUtil;
import com.zyx.common.core.page.TableDataInfo;

/**
 * 用户历史行为Controller
 *
 * @author 张银祥
 * @date 2022-01-16
 */
@Controller
@RequestMapping("/system/history")
public class SysHistoryController extends BaseController
{
    private String prefix = "system/history";

    @Autowired
    private ISysHistoryService sysHistoryService;

    @RequiresPermissions("system:history:view")
    @GetMapping()
    public String history()
    {
        return prefix + "/history";
    }

    /**
     * 查询用户历史行为列表
     */
    @RequiresPermissions("system:history:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysHistory sysHistory)
    {
        startPage();
        List<SysHistory> list = sysHistoryService.selectSysHistoryList(sysHistory);
        return getDataTable(list);
    }

    /**
     * 导出用户历史行为列表
     */
    @RequiresPermissions("system:history:export")
    @Log(title = "用户历史行为", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysHistory sysHistory)
    {
        List<SysHistory> list = sysHistoryService.selectSysHistoryList(sysHistory);
        ExcelUtil<SysHistory> util = new ExcelUtil<SysHistory>(SysHistory.class);
        return util.exportExcel(list, "用户历史行为数据");
    }

    /**
     * 新增用户历史行为
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户历史行为
     */
    @RequiresPermissions("system:history:add")
    @Log(title = "用户历史行为", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysHistory sysHistory)
    {
        return toAjax(sysHistoryService.insertSysHistory(sysHistory));
    }

    /**
     * 修改用户历史行为
     */
    @GetMapping("/edit/{historyId}")
    public String edit(@PathVariable("historyId") Long historyId, ModelMap mmap)
    {
        SysHistory sysHistory = sysHistoryService.selectSysHistoryById(historyId);
        mmap.put("sysHistory", sysHistory);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户历史行为
     */
    @RequiresPermissions("system:history:edit")
    @Log(title = "用户历史行为", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysHistory sysHistory)
    {
        return toAjax(sysHistoryService.updateSysHistory(sysHistory));
    }

    /**
     * 删除用户历史行为
     */
    @RequiresPermissions("system:history:remove")
    @Log(title = "用户历史行为", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysHistoryService.deleteSysHistoryByIds(ids));
    }
}