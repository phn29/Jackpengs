package com.zyx.web.controller.client;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyx.common.core.domain.entity.SysUniversity;
import com.zyx.system.service.impl.SysUniversityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/client")
public class clientUniversityIdentificationController {
    @Autowired
    private SysUniversityServiceImpl sysUniversityService;

    //跳转院校识别页面
    @GetMapping("/universityIdentification")
    public String universityIdentification(Model model, SysUniversity sysUniversity, ModelMap maap,
                                           @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum)
    {
        maap.put("universitys", sysUniversityService.selectSysUniversityAll());
        PageHelper.startPage(pageNum,20);
        //获取野鸡大学信息列表
        List<SysUniversity> universities = sysUniversityService.selectUniversityYj(sysUniversity);
        PageInfo<SysUniversity> pageInfo = new PageInfo<>(universities);
        model.addAttribute("pageInfo", pageInfo);
        return "client/universityDiscern/universityIdentification";
    }

    //跳转院校识别页面
    @PostMapping("/universityIdentification")
    public String selectUniversityIdentification(Model model, SysUniversity sysUniversity, ModelMap maap,
                                           @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum)
    {
        maap.put("universitys", sysUniversityService.selectSysUniversityAll());
        PageHelper.startPage(pageNum,20);
        //获取大学信息列表
        List<SysUniversity> universities = sysUniversityService.selectSysUniversityList(sysUniversity);
        PageInfo<SysUniversity> pageInfo = new PageInfo<>(universities);
        model.addAttribute("pageInfo", pageInfo);
        return "client/universityDiscern/universityIdentification :: universityList";
    }
}
