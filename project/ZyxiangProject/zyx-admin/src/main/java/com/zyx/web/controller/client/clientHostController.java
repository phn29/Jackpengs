package com.zyx.web.controller.client;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyx.common.core.domain.entity.SysHost;
import com.zyx.system.service.ISysHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class clientHostController {
    @Autowired
    private ISysHostService sysHostService;
    @Component("timingTask")
    public class TimingTaskImpl {

        public void startTask(){
            System.out.println("定时任务启动");
        }
    }

    //跳转查高考咨询页面
    @GetMapping("/selectConsult")
    public String selectConsult(Model model, SysHost sysHost,
                                @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,8);
        //获取高考咨询信息列表
        List<SysHost> hosts = sysHostService.selectSysHostList(sysHost);
        PageInfo<SysHost> pageInfoHost = new PageInfo<>(hosts);
        model.addAttribute("pageInfoHost", pageInfoHost);
        return "client/consult/consult_list";
    }
    //跳转查高考咨询页面
    @PostMapping("/selectConsult")
    public String selectHost(Model model, SysHost sysHost,
                                @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,8);
        //获取高考咨询信息列表
        List<SysHost> hosts = sysHostService.selectSysHostList(sysHost);
        PageInfo<SysHost> pageInfoHost = new PageInfo<>(hosts);
        model.addAttribute("pageInfoHost", pageInfoHost);
        return "client/consult/consult_list::hostList";
    }

    //跳转咨询详情页面
    @GetMapping("/consultDetail/{hostId}")
    public String consultDetail(@PathVariable Long hostId, Model model){
        SysHost consultDetail = sysHostService.selectSysHostById(hostId);
        model.addAttribute("SysHost",consultDetail);
        return "client/consult/consult_info";
    }
}
