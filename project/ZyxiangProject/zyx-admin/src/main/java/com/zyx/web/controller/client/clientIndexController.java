package com.zyx.web.controller.client;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyx.common.core.controller.BaseController;
import com.zyx.common.core.domain.entity.SysExpert;
import com.zyx.common.core.domain.entity.SysHost;
import com.zyx.common.core.domain.entity.SysTimeaxis;
import com.zyx.common.core.domain.entity.SysUniversity;
import com.zyx.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 山东新高考志愿智能决策||前台首页管理
 *
 * @author 张银祥
 * @date 2021-05-26
 */

@Controller
@RequestMapping("/client")
public class clientIndexController extends BaseController
{
    @Autowired
    private ISysUniversityService sysUniversityService;

    @Autowired
    private ISysHostService sysHostService;

    @Autowired
    private ISysTimeaxisService sysTimeaxisService;

    @Autowired
    private ISysMajorService sysMajorService;

    @Autowired
    private ISysExpertService sysExpertService;

    //跳转前台首页
    @GetMapping("/universityIndex")
    public String universityIndex(Model model, SysUniversity sysUniversity, SysExpert sysExpert,
                                  SysHost sysHost, SysTimeaxis sysTimeaxis,
                                  @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum)
    {
        //获取大学信息列表
        PageHelper.startPage(pageNum,10);
        List<SysUniversity> universities = sysUniversityService.selectSysUniversityList(sysUniversity);
        PageInfo<SysUniversity> pageInfo = new PageInfo<>(universities);
        model.addAttribute("pageInfo",pageInfo);

        //获取热点数据列表
        PageHelper.startPage(pageNum,5);
        List<SysHost> hosts = sysHostService.selectSysHostList(sysHost);
        PageInfo<SysHost> pageInfoHost = new PageInfo<>(hosts);
        model.addAttribute("pageInfoHost",pageInfoHost);

        //获取高考时间轴数据列表
        List<SysTimeaxis> timeaxes = sysTimeaxisService.selectSysTimeaxisList(sysTimeaxis);
        PageInfo<SysTimeaxis> pageInfoTimeAxis = new PageInfo<>(timeaxes);
        model.addAttribute("pageInfoTimeAxis",pageInfoTimeAxis);

        //专家入驻
        List<SysExpert> sysExperts = sysExpertService.selectSysExpertList(sysExpert);
        PageInfo<SysExpert> sysExpertPageInfo = new PageInfo<>(sysExperts);
        model.addAttribute("sysExpertPageInfo", sysExpertPageInfo);

        return "client/index/index";
    }

    //查询山东本科院校
    @PostMapping("/sdBkUniversity")
    @ResponseBody
    public List<SysUniversity> sdBkUniversity(int page, int rows){
        return sysUniversityService.sdBkUniversity(page, rows);
    }

    //查询山东专科院校
    @PostMapping("/sdZkUniversity")
    @ResponseBody
    public List<SysUniversity> sdZkUniversity(int page, int rows){
        return sysUniversityService.sdZkUniversity(page, rows);
    }



    //查专业，查学校，
    //跳转关于我们页面
    @GetMapping("/about")
    public String about(){
        return "client/about/about";
    }

}
