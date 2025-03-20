package com.zyx.web.controller.client;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyx.common.core.domain.entity.SysHistory;
import com.zyx.common.core.domain.entity.SysHost;
import com.zyx.common.core.domain.entity.SysMajor;
import com.zyx.common.core.domain.entity.SysSalary;
import com.zyx.system.domain.ResponseData;
import com.zyx.system.service.ISysHistoryService;
import com.zyx.system.service.ISysHostService;
import com.zyx.system.service.ISysMajorService;
import com.zyx.system.service.ISysSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/client")
public class clientMajorController {
    @Autowired
    private ISysMajorService sysMajorService;
    @Autowired
    private ISysSalaryService sysSalaryService;
    @Autowired
    private ISysHistoryService sysHistoryService;

    //跳转查询专业页面
    @GetMapping("/selectMajor")
    public String selectMajor(Model model, SysMajor sysMajor, ModelMap mmap, HttpSession session,
                              @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum)
    {
        mmap.put("majors", sysMajorService.selectSysMajorAll());
        PageHelper.startPage(pageNum,14);
        //获取专业信息列表
        List<SysMajor> majors = sysMajorService.selectSysMajorList(sysMajor);
        PageInfo<SysMajor> pageInfoMajor = new PageInfo<>(majors);
        model.addAttribute("pageInfoMajor", pageInfoMajor);
        return "client/major/major_list";
    }

    //搜专业页面
    @PostMapping("/selectMajor")
    public String searchMajor(Model model, SysMajor sysMajor, ModelMap mmap,
                              @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum)
    {
        mmap.put("majors", sysMajorService.selectSysMajorAll());
        PageHelper.startPage(pageNum,14);
        //获取专业信息列表
        List<SysMajor> majors = sysMajorService.selectSysMajorList(sysMajor);
        PageInfo<SysMajor> pageInfoMajor = new PageInfo<>(majors);
        model.addAttribute("pageInfoMajor", pageInfoMajor);
        return "client/major/major_list::majorList";
    }

    //跳转专业详情页面
    @GetMapping("/majorDetail/{majorId}")
    public String majorDetail(@PathVariable Long majorId, SysSalary sysSalary, Model model,
                              @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        SysMajor majorDetail = sysMajorService.selectSysMajorById(majorId);
        model.addAttribute("SysMajor",majorDetail);
        //查询专业薪资
        PageHelper.startPage(pageNum, 10);
        List<SysSalary> listSalary = sysSalaryService.selectSysSalaryList(sysSalary);
        PageInfo<SysSalary> salaryPageInfo = new PageInfo<>(listSalary);
        model.addAttribute("salaryPageInfo", salaryPageInfo);
        //查询专业平均薪资
        SysSalary averageSalary = sysSalaryService.selectAverageSalary(sysSalary);
        model.addAttribute("averageSalary", averageSalary);
        return "client/major/major_info";
    }

    //记录用户访问某个专业的记录
    @PostMapping("/majorHistory/add")
    @ResponseBody
    public ResponseData majorHistory(SysHistory sysHistory){
        try {
            sysHistoryService.insertSysHistory(sysHistory);
            return ResponseData.ok("添加成功");
        }catch (Exception e){
            return ResponseData.fail("添加失败");
        }
    }

    //历年专业薪资数据可视化
    @RequestMapping(value = "majorDetail/{majorId}/salary",method = RequestMethod.GET)
    @ResponseBody
    public List<SysSalary> showSalaryData(@PathVariable("majorId") Long majorId){
        List<SysSalary> salary = sysSalaryService.selectSysSalaryByMajorId(majorId);
        return salary;
    }
}
