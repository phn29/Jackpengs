package com.zyx.web.controller.system;

import com.zyx.common.annotation.Log;
import com.zyx.common.core.controller.BaseController;
import com.zyx.common.core.domain.AjaxResult;
import com.zyx.common.core.page.TableDataInfo;
import com.zyx.common.enums.BusinessType;
import com.zyx.common.utils.ShiroUtils;
import com.zyx.common.utils.poi.ExcelUtil;
import com.zyx.common.core.domain.entity.SysMajor;
import com.zyx.system.service.ISysMajorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 专业表Controller
 *
 * @author 张银祥
 * @date 2021-05-26
 */
@Controller
@RequestMapping("/system/major")
public class SysMajorController extends BaseController
{
    private String prefix = "system/major";

    @Autowired
    private ISysMajorService sysMajorService;

    @RequiresPermissions("system:major:view")
    @GetMapping()
    public String major()
    {
        return prefix + "/major";
    }

    /**
     * 查询专业表列表
     */
    @RequiresPermissions("system:major:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysMajor sysMajor)
    {
        startPage();
        List<SysMajor> list = sysMajorService.selectSysMajorList(sysMajor);
        return getDataTable(list);
    }

    /**
     * 导出专业表列表
     */
    @RequiresPermissions("system:major:export")
    @Log(title = "专业表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysMajor sysMajor)
    {
        List<SysMajor> list = sysMajorService.selectSysMajorList(sysMajor);
        ExcelUtil<SysMajor> util = new ExcelUtil<SysMajor>(SysMajor.class);
        return util.exportExcel(list, "专业表数据");
    }

    /**
     * 导入专业表列表
     */
    @Log(title = "专业表", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:major:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<SysMajor> util = new ExcelUtil<SysMajor>(SysMajor.class);
        List<SysMajor> majorList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = sysMajorService.importMajor(majorList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("system:major:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<SysMajor> util = new ExcelUtil<SysMajor>(SysMajor.class);
        return util.importTemplateExcel("专业数据");
    }

    /**
     * 新增专业表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存专业表
     */
    @RequiresPermissions("system:major:add")
    @Log(title = "专业表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysMajor sysMajor)
    {
        return toAjax(sysMajorService.insertSysMajor(sysMajor));
    }

    /**
     * 修改专业表
     */
    @GetMapping("/edit/{majorId}")
    public String edit(@PathVariable("majorId") Long majorId, ModelMap mmap)
    {
        SysMajor sysMajor = sysMajorService.selectSysMajorById(majorId);
        mmap.put("sysMajor", sysMajor);
        return prefix + "/edit";
    }

    /**
     * 修改保存专业表
     */
    @RequiresPermissions("system:major:edit")
    @Log(title = "专业表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysMajor sysMajor)
    {
        return toAjax(sysMajorService.updateSysMajor(sysMajor));
    }

    /**
     * 删除专业表
     */
    @RequiresPermissions("system:major:remove")
    @Log(title = "专业表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysMajorService.deleteSysMajorByIds(ids));
    }
}