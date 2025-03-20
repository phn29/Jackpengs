package com.zyx.web.controller.client;

import com.zyx.common.core.domain.entity.SysExpert;
import com.zyx.common.core.domain.entity.SysStudent;
import com.zyx.system.domain.ResponseData;
import com.zyx.system.service.ISysExpertService;
import com.zyx.system.service.ISysStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/client")
public class LoginAndRegisterController {
    @Autowired
    private ISysStudentService sysStudentService;
    @Autowired
    private ISysExpertService sysExpertService;

    //跳转登录注册页面
    @GetMapping("/login")
    public String LoginAndRegister(){
        return "client/loginAndRegister/loginAndRegister";
    }

    //判断登录用户是，0：普通用户，还是1：咨询师
    @PostMapping("/login")
    public String Login(@RequestParam String userName, @RequestParam String password, @RequestParam String role,
                        RedirectAttributes attributes,
                        HttpSession session){
        //普通用户登录
        if(role.equals("0")){
            SysStudent sysStudent = sysStudentService.checkUser(userName, password);
            if(sysStudent != null){
                sysStudent.setStuPassword(null);
                session.removeAttribute("SysExpert");
                session.setAttribute("SysStudent",sysStudent);
                return "redirect:/client/universityIndex";
            }
        }
        //咨询师登录
        if(role.equals("1")){
            SysExpert sysExpert = sysExpertService.checkUser(userName, password);
            if(sysExpert != null){
                sysExpert.setExpertPassword(null);
                session.removeAttribute("SysStudent");
                session.setAttribute("SysExpert",sysExpert);
                return "redirect:/client/universityIndex";
            }
        }
        attributes.addFlashAttribute("message", "登录失败，用户名或密码错误，请重新输入");
        return "redirect:/client/login";
    }

    //用户注册
    @PostMapping("/register")
    public String Register(SysStudent sysStudent, RedirectAttributes attributes){
        int stu = sysStudentService.insertSysStudent(sysStudent);
        if(stu != 0 ){
            attributes.addFlashAttribute("message","注册成功！");
        }else{
            attributes.addFlashAttribute("message","注册失败！");
        }
        return "redirect:/client/login";
    }

    //退出登录
    @GetMapping("/logout")
    public String Logout(HttpSession session){
        session.removeAttribute("SysExpert");
        session.removeAttribute("sysStudent");
        return "redirect:/client/universityIndex";
    }

}
