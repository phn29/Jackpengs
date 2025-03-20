package com.zyx.web.controller.client;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyx.common.core.domain.entity.SysHost;
import com.zyx.common.core.domain.entity.SysRanking;
import com.zyx.common.core.domain.entity.SysTimeaxis;
import com.zyx.system.service.ISysHostService;
import com.zyx.system.service.ISysRankingService;
import com.zyx.system.service.ISysTimeaxisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class clientRankingController {
    @Autowired
    private ISysRankingService sysRankingService;
    @Autowired
    private ISysHostService sysHostService;
    @Autowired
    private ISysTimeaxisService sysTimeaxisService;

    //跳转一分一段表（位次表）页面
    @GetMapping("/selectRanking")
    public String selectRanking(Model model, SysRanking sysRanking, SysHost sysHost, SysTimeaxis sysTimeaxis,
                              @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum)
    {
        PageHelper.startPage(pageNum,20);
        //获取一分一段位次列表
        List<SysRanking> rankingList = sysRankingService.selectSysRankingList(sysRanking);
        PageInfo<SysRanking> pageInfoRanking = new PageInfo<>(rankingList);
        model.addAttribute("pageInfoRanking", pageInfoRanking);

        //获取热点数据列表
        List<SysHost> hosts = sysHostService.selectSysHostList(sysHost);
        PageInfo<SysHost> pageInfoHost = new PageInfo<>(hosts);
        model.addAttribute("pageInfoHost",pageInfoHost);

        //获取高考时间轴数据列表
        List<SysTimeaxis> timeaxes = sysTimeaxisService.selectSysTimeaxisList(sysTimeaxis);
        PageInfo<SysTimeaxis> pageInfoTimeAxis = new PageInfo<>(timeaxes);
        model.addAttribute("pageInfoTimeAxis",pageInfoTimeAxis);
        return "client/ranking/ranking_list";
    }

    //搜索一分一段表（位次表）
    @PostMapping("/selectRanking")
    public String selectRankingList(Model model, SysRanking sysRanking, SysHost sysHost, SysTimeaxis sysTimeaxis,
                              @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum)
    {
        PageHelper.startPage(pageNum,20);
        //获取一分一段位次列表
        List<SysRanking> rankingList = sysRankingService.selectSysRankingList(sysRanking);
        PageInfo<SysRanking> pageInfoRanking = new PageInfo<>(rankingList);
        model.addAttribute("pageInfoRanking", pageInfoRanking);

        //获取热点数据列表
        List<SysHost> hosts = sysHostService.selectSysHostList(sysHost);
        PageInfo<SysHost> pageInfoHost = new PageInfo<>(hosts);
        model.addAttribute("pageInfoHost",pageInfoHost);

        //获取高考时间轴数据列表
        List<SysTimeaxis> timeaxes = sysTimeaxisService.selectSysTimeaxisList(sysTimeaxis);
        PageInfo<SysTimeaxis> pageInfoTimeAxis = new PageInfo<>(timeaxes);
        model.addAttribute("pageInfoTimeAxis",pageInfoTimeAxis);

        return "client/ranking/ranking_list::rankingList";
    }

    //位次表可视化数据
    @RequestMapping(value = "showRankingData",method = RequestMethod.GET)
    @ResponseBody
    public List<SysRanking> showRankingData(SysRanking sysRanking){
        List<SysRanking> rankingList = sysRankingService.selectSysRankingList(sysRanking);
        return rankingList;
    }
//    //历年招生计划数据可视化
//    @RequestMapping(value = "universityDetail/{universityId}/plan",method = RequestMethod.GET)
//    @ResponseBody
//    public List<SysPlan> showPlanData(@PathVariable("universityId") Long universityId){
//        List<SysPlan> plans = sysPlanService.selectSysPlanByUniversityId(universityId);
//        return plans;
//    }
}
