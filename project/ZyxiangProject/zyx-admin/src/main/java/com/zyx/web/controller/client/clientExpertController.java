package com.zyx.web.controller.client;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyx.common.core.domain.entity.SysExpert;
import com.zyx.system.service.ISysExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/client")
public class clientExpertController {
    @Autowired
    private ISysExpertService sysExpertService;

    //跳转查询咨询师页面
    @GetMapping("/selectExpert")
    public String selectExpert(Model model, SysExpert sysExpert,
                                   @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,20);
        //获取咨询师列表
        List<SysExpert> sysExperts = sysExpertService.selectSysExpertList(sysExpert);
        PageInfo<SysExpert> sysExpertPageInfo = new PageInfo<>(sysExperts);
        model.addAttribute("sysExpertPageInfo", sysExpertPageInfo);
        return "client/expert/expert_list";
    }
    //跳转咨询师详情页面
    @GetMapping("/selectExpertInfo/{expertId}")
    public String ExpertInfo(@PathVariable Long expertId, Model model){
        SysExpert sysExpert = sysExpertService.selectSysExpertById(expertId);
        model.addAttribute("SysExpert", sysExpert);
        return "client/expert/expert_info";
    }
}
