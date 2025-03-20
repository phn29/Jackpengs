package com.zyx.web.controller.system;

import java.util.List;

import com.zyx.common.annotation.Excel;
import com.zyx.common.core.domain.entity.SysRanking;
import com.zyx.common.utils.ShiroUtils;
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
import com.zyx.system.service.ISysRankingService;
import com.zyx.common.core.controller.BaseController;
import com.zyx.common.core.domain.AjaxResult;
import com.zyx.common.utils.poi.ExcelUtil;
import com.zyx.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 一分一段表（位次表）Controller
 *
 * @author 张银祥
 * @date 2021-08-10
 */
@Controller
@RequestMapping("/system/ranking")
public class SysRankingController extends BaseController
{
    private String prefix = "system/ranking";

    @Autowired
    private ISysRankingService sysRankingService;

    @RequiresPermissions("system:ranking:view")
    @GetMapping()
    public String ranking()
    {
        return prefix + "/ranking";
    }

    /**
     * 查询一分一段表（位次表）列表
     */
    @RequiresPermissions("system:ranking:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysRanking sysRanking)
    {
        startPage();
        List<SysRanking> list = sysRankingService.selectSysRankingList(sysRanking);
        return getDataTable(list);
    }

    /**
     * 导出一分一段表（位次表）列表
     */
    @RequiresPermissions("system:ranking:export")
    @Log(title = "一分一段表（位次表）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysRanking sysRanking)
    {
        List<SysRanking> list = sysRankingService.selectSysRankingList(sysRanking);
        ExcelUtil<SysRanking> util = new ExcelUtil<SysRanking>(SysRanking.class);
        return util.exportExcel(list, "一分一段表（位次表）数据");
    }

    /**
     * 导入一分一段表（位次表）列表
     */
    @Log(title = "招生计划表", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:ranking:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<SysRanking> util = new ExcelUtil<>(SysRanking.class);
        List<SysRanking> rankingList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = sysRankingService.importRanking(rankingList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("system:ranking:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<SysRanking> util = new ExcelUtil<>(SysRanking.class);
        return util.importTemplateExcel("招生计划数据");
    }

    /**
     * 新增一分一段表（位次表）
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存一分一段表（位次表）
     */
    @RequiresPermissions("system:ranking:add")
    @Log(title = "一分一段表（位次表）", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysRanking sysRanking)
    {
        return toAjax(sysRankingService.insertSysRanking(sysRanking));
    }

    /**
     * 修改一分一段表（位次表）
     */
    @GetMapping("/edit/{rankingId}")
    public String edit(@PathVariable("rankingId") Long rankingId, ModelMap mmap)
    {
        SysRanking sysRanking = sysRankingService.selectSysRankingById(rankingId);
        mmap.put("sysRanking", sysRanking);
        return prefix + "/edit";
    }

    /**
     * 修改保存一分一段表（位次表）
     */
    @RequiresPermissions("system:ranking:edit")
    @Log(title = "一分一段表（位次表）", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysRanking sysRanking)
    {
        return toAjax(sysRankingService.updateSysRanking(sysRanking));
    }

    /**
     * 删除一分一段表（位次表）
     */
    @RequiresPermissions("system:ranking:remove")
    @Log(title = "一分一段表（位次表）", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysRankingService.deleteSysRankingByIds(ids));
    }
}
