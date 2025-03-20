package com.zyx.web.controller.system;

import com.zyx.common.annotation.Log;
import com.zyx.common.core.controller.BaseController;
import com.zyx.common.core.domain.AjaxResult;
import com.zyx.common.core.domain.entity.SysStudent;
import com.zyx.common.core.page.TableDataInfo;
import com.zyx.common.enums.BusinessType;
import com.zyx.common.utils.poi.ExcelUtil;
import com.zyx.system.service.ISysStudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * 学生表Controller
 *
 * @author 张银祥
 * @date 2021-05-26
 */
@Controller
@RequestMapping("/system/student")
public class SysStudentController extends BaseController
{
    private String prefix = "system/student";

    @Autowired
    private ISysStudentService sysStudentService;

    @RequiresPermissions("system:student:view")
    @GetMapping()
    public String student()
    {
        return prefix + "/student";
    }

    /**
     * 查询学生表列表
     */
    @RequiresPermissions("system:student:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysStudent sysStudent)
    {
        startPage();
        List<SysStudent> list = sysStudentService.selectSysStudentList(sysStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生表列表
     */
    @RequiresPermissions("system:student:export")
    @Log(title = "学生表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysStudent sysStudent)
    {
        List<SysStudent> list = sysStudentService.selectSysStudentList(sysStudent);
        ExcelUtil<SysStudent> util = new ExcelUtil<SysStudent>(SysStudent.class);
        return util.exportExcel(list, "学生表数据");
    }

    /**
     * 新增学生表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生表
     */
    @RequiresPermissions("system:student:add")
    @Log(title = "学生表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysStudent sysStudent)
    {
        return toAjax(sysStudentService.insertSysStudent(sysStudent));
    }

    /**
     * 修改学生表
     */
    @GetMapping("/edit/{stuId}")
    public String edit(@PathVariable("stuId") Long stuId, ModelMap mmap)
    {
        SysStudent sysStudent = sysStudentService.selectSysStudentById(stuId);
        mmap.put("sysStudent", sysStudent);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生表
     */
    @RequiresPermissions("system:student:edit")
    @Log(title = "学生表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysStudent sysStudent) throws IOException, ParseException {
        return toAjax(sysStudentService.updateSysStudent(sysStudent));
    }

    /**
     * 删除学生表
     */
    @RequiresPermissions("system:student:remove")
    @Log(title = "学生表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysStudentService.deleteSysStudentByIds(ids));
    }
}