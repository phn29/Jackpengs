package com.zyx.web.controller.system;

import com.zyx.common.annotation.Log;
import com.zyx.common.core.controller.BaseController;
import com.zyx.common.core.domain.AjaxResult;
import com.zyx.common.core.domain.entity.SysNature;
import com.zyx.common.core.page.TableDataInfo;
import com.zyx.common.enums.BusinessType;
import com.zyx.common.utils.poi.ExcelUtil;
import com.zyx.system.service.ISysNatureService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * MBTI职业性格测试题Controller
 *
 * @author zyx
 * @date 2022-03-19
 */
@Controller
@RequestMapping("/system/nature")
public class SysNatureController extends BaseController
{
    private String prefix = "system/nature";

    @Autowired
    private ISysNatureService sysNatureService;

    @RequiresPermissions("system:nature:view")
    @GetMapping()
    public String nature()
    {
        return prefix + "/nature";
    }

    /**
     * 查询MBTI职业性格测试题列表
     */
    @RequiresPermissions("system:nature:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysNature sysNature)
    {
        startPage();
        List<SysNature> list = sysNatureService.selectSysNatureList(sysNature);
        return getDataTable(list);
    }

    /**
     * 导出MBTI职业性格测试题列表
     */
    @RequiresPermissions("system:nature:export")
    @Log(title = "MBTI职业性格测试题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysNature sysNature)
    {
        List<SysNature> list = sysNatureService.selectSysNatureList(sysNature);
        ExcelUtil<SysNature> util = new ExcelUtil<SysNature>(SysNature.class);
        return util.exportExcel(list, "MBTI职业性格测试题数据");
    }

    /**
     * 新增MBTI职业性格测试题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存MBTI职业性格测试题
     */
    @RequiresPermissions("system:nature:add")
    @Log(title = "MBTI职业性格测试题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysNature sysNature)
    {
        return toAjax(sysNatureService.insertSysNature(sysNature));
    }

    /**
     * 修改MBTI职业性格测试题
     */
    @GetMapping("/edit/{natureId}")
    public String edit(@PathVariable("natureId") Long natureId, ModelMap mmap)
    {
        SysNature sysNature = sysNatureService.selectSysNatureById(natureId);
        mmap.put("sysNature", sysNature);
        return prefix + "/edit";
    }

    /**
     * 修改保存MBTI职业性格测试题
     */
    @RequiresPermissions("system:nature:edit")
    @Log(title = "MBTI职业性格测试题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysNature sysNature)
    {
        return toAjax(sysNatureService.updateSysNature(sysNature));
    }

    /**
     * 删除MBTI职业性格测试题
     */
    @RequiresPermissions("system:nature:remove")
    @Log(title = "MBTI职业性格测试题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysNatureService.deleteSysNatureByIds(ids));
    }
}
