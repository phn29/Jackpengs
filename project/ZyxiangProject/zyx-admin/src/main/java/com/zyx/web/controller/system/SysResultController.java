package com.zyx.web.controller.system;

import com.zyx.common.annotation.Log;
import com.zyx.common.core.controller.BaseController;
import com.zyx.common.core.domain.AjaxResult;
import com.zyx.common.core.domain.entity.SysResult;
import com.zyx.common.core.page.TableDataInfo;
import com.zyx.common.enums.BusinessType;
import com.zyx.common.utils.poi.ExcelUtil;
import com.zyx.system.service.ISysResultService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 心理测试结果表Controller
 * 
 * @author zyx
 * @date 2022-04-30
 */
@Controller
@RequestMapping("/system/result")
public class SysResultController extends BaseController
{
    private String prefix = "system/result";

    @Autowired
    private ISysResultService sysResultService;

    @RequiresPermissions("system:result:view")
    @GetMapping()
    public String result()
    {
        return prefix + "/result";
    }

    /**
     * 查询心理测试结果表列表
     */
    @RequiresPermissions("system:result:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysResult sysResult)
    {
        startPage();
        List<SysResult> list = sysResultService.selectSysResultList(sysResult);
        return getDataTable(list);
    }

    /**
     * 导出心理测试结果表列表
     */
    @RequiresPermissions("system:result:export")
    @Log(title = "心理测试结果表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysResult sysResult)
    {
        List<SysResult> list = sysResultService.selectSysResultList(sysResult);
        ExcelUtil<SysResult> util = new ExcelUtil<SysResult>(SysResult.class);
        return util.exportExcel(list, "心理测试结果表数据");
    }

    /**
     * 新增心理测试结果表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存心理测试结果表
     */
    @RequiresPermissions("system:result:add")
    @Log(title = "心理测试结果表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysResult sysResult)
    {
        return toAjax(sysResultService.insertSysResult(sysResult));
    }

    /**
     * 修改心理测试结果表
     */
    @GetMapping("/edit/{resultId}")
    public String edit(@PathVariable("resultId") String resultId, ModelMap mmap)
    {
        SysResult sysResult = sysResultService.selectSysResultById(resultId);
        mmap.put("sysResult", sysResult);
        return prefix + "/edit";
    }

    /**
     * 修改保存心理测试结果表
     */
    @RequiresPermissions("system:result:edit")
    @Log(title = "心理测试结果表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysResult sysResult)
    {
        return toAjax(sysResultService.updateSysResult(sysResult));
    }

    /**
     * 删除心理测试结果表
     */
    @RequiresPermissions("system:result:remove")
    @Log(title = "心理测试结果表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysResultService.deleteSysResultByIds(ids));
    }
}