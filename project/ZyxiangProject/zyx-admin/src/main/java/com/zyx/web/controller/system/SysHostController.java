package com.zyx.web.controller.system;

import java.util.List;
import com.zyx.common.core.domain.entity.SysHost;
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
import com.zyx.system.service.ISysHostService;
import com.zyx.common.core.controller.BaseController;
import com.zyx.common.core.domain.AjaxResult;
import com.zyx.common.utils.poi.ExcelUtil;
import com.zyx.common.core.page.TableDataInfo;

/**
 * 热点新闻表Controller
 * 
 * @author 张银祥
 * @date 2021-05-29
 */
@Controller
@RequestMapping("/system/host")
public class SysHostController extends BaseController
{
    private String prefix = "system/host";

    @Autowired
    private ISysHostService sysHostService;

    @RequiresPermissions("system:host:view")
    @GetMapping()
    public String host()
    {
        return prefix + "/host";
    }

    /**
     * 查询热点新闻表列表
     */
    @RequiresPermissions("system:host:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysHost sysHost)
    {
        startPage();
        List<SysHost> list = sysHostService.selectSysHostList(sysHost);
        return getDataTable(list);
    }

    /**
     * 导出热点新闻表列表
     */
    @RequiresPermissions("system:host:export")
    @Log(title = "热点新闻表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysHost sysHost)
    {
        List<SysHost> list = sysHostService.selectSysHostList(sysHost);
        ExcelUtil<SysHost> util = new ExcelUtil<SysHost>(SysHost.class);
        return util.exportExcel(list, "热点新闻表数据");
    }

    /**
     * 新增热点新闻表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存热点新闻表
     */
    @RequiresPermissions("system:host:add")
    @Log(title = "热点新闻表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysHost sysHost)
    {
        return toAjax(sysHostService.insertSysHost(sysHost));
    }

    /**
     * 修改热点新闻表
     */
    @GetMapping("/edit/{hostId}")
    public String edit(@PathVariable("hostId") Long hostId, ModelMap mmap)
    {
        SysHost sysHost = sysHostService.selectSysHostById(hostId);
        mmap.put("sysHost", sysHost);
        return prefix + "/edit";
    }

    /**
     * 修改保存热点新闻表
     */
    @RequiresPermissions("system:host:edit")
    @Log(title = "热点新闻表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysHost sysHost)
    {
        return toAjax(sysHostService.updateSysHost(sysHost));
    }

    /**
     * 删除热点新闻表
     */
    @RequiresPermissions("system:host:remove")
    @Log(title = "热点新闻表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysHostService.deleteSysHostByIds(ids));
    }
}
