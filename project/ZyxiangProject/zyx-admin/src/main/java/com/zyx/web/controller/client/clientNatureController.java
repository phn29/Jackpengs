package com.zyx.web.controller.client;

import com.zyx.common.core.domain.entity.SysNature;
import com.zyx.system.service.ISysNatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/client")
public class clientNatureController {
    @Autowired
    private ISysNatureService sysNatureService;

    //跳转心理测试页面
    @GetMapping("/nature")
    public String nature(SysNature sysNature, HttpServletRequest request){
        List<SysNature> sysNatures = sysNatureService.selectSysNatureList(sysNature);
        request.setAttribute("sysNatures", sysNatures);
        return "client/nature/nature_list";
    }


}
