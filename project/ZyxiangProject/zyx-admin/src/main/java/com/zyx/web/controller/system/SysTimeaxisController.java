package com.zyx.web.controller.system;

import java.util.List;
import com.zyx.common.core.domain.entity.SysTimeaxis;
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
import com.zyx.system.service.ISysTimeaxisService;
import com.zyx.common.core.controller.BaseController;
import com.zyx.common.core.domain.AjaxResult;
import com.zyx.common.utils.poi.ExcelUtil;
import com.zyx.common.core.page.TableDataInfo;

/**
 * 高考时间轴表Controller
 * 
 * @author 张银祥
 * @date 2021-05-31
 */
@Controller
@RequestMapping("/system/timeaxis")
public class SysTimeaxisController extends BaseController
{
    private String prefix = "system/timeaxis";

    @Autowired
    private ISysTimeaxisService sysTimeaxisService;

    @RequiresPermissions("system:timeaxis:view")
    @GetMapping()
    public String timeaxis()
    {
        return prefix + "/timeaxis";
    }

    /**
     * 查询高考时间轴表列表
     */
    @RequiresPermissions("system:timeaxis:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysTimeaxis sysTimeaxis)
    {
        startPage();
        List<SysTimeaxis> list = sysTimeaxisService.selectSysTimeaxisList(sysTimeaxis);
        return getDataTable(list);
    }

    /**
     * 导出高考时间轴表列表
     */
    @RequiresPermissions("system:timeaxis:export")
    @Log(title = "高考时间轴表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysTimeaxis sysTimeaxis)
    {
        List<SysTimeaxis> list = sysTimeaxisService.selectSysTimeaxisList(sysTimeaxis);
        ExcelUtil<SysTimeaxis> util = new ExcelUtil<SysTimeaxis>(SysTimeaxis.class);
        return util.exportExcel(list, "高考时间轴表数据");
    }

    /**
     * 新增高考时间轴表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存高考时间轴表
     */
    @RequiresPermissions("system:timeaxis:add")
    @Log(title = "高考时间轴表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysTimeaxis sysTimeaxis)
    {
        return toAjax(sysTimeaxisService.insertSysTimeaxis(sysTimeaxis));
    }

    /**
     * 修改高考时间轴表
     */
    @GetMapping("/edit/{timeAxisId}")
    public String edit(@PathVariable("timeAxisId") Long timeAxisId, ModelMap mmap)
    {
        SysTimeaxis sysTimeaxis = sysTimeaxisService.selectSysTimeaxisById(timeAxisId);
        mmap.put("sysTimeaxis", sysTimeaxis);
        return prefix + "/edit";
    }

    /**
     * 修改保存高考时间轴表
     */
    @RequiresPermissions("system:timeaxis:edit")
    @Log(title = "高考时间轴表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysTimeaxis sysTimeaxis)
    {
        return toAjax(sysTimeaxisService.updateSysTimeaxis(sysTimeaxis));
    }

    /**
     * 删除高考时间轴表
     */
    @RequiresPermissions("system:timeaxis:remove")
    @Log(title = "高考时间轴表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysTimeaxisService.deleteSysTimeaxisByIds(ids));
    }
}
