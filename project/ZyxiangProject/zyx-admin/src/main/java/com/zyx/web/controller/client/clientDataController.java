package com.zyx.web.controller.client;

import com.zyx.common.core.domain.entity.SysChat;
import com.zyx.common.core.domain.entity.SysHistory;
import com.zyx.common.core.domain.entity.SysStudent;
import com.zyx.system.service.ISysChatService;
import com.zyx.system.service.ISysHistoryService;
import com.zyx.system.service.ISysStudentService;
import com.zyx.system.service.ISysVolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/client/personal")
public class clientDataController {

    @Autowired
    private ISysChatService sysChatService;
    @Autowired
    private ISysHistoryService sysHistoryService;
    @Autowired
    private ISysStudentService sysStudentService;
    @Autowired
    private ISysVolunteerService sysVolunteerService;

    //跳转欢迎页面
    @GetMapping("/welcome")
    public String welcome(HttpServletRequest request, HttpSession session){
        //查询用户的咨询师
        SysStudent sysStudent = (SysStudent) session.getAttribute("SysStudent");
        if(sysStudent != null){
            String stuId = sysStudent.getStuId().toString();
            //查询用户的咨询师
            List<SysChat> sysChats = sysChatService.selectMyself(stuId, "");
            request.setAttribute("sysChats", sysChats);
            //查询访问最多专业
            List<SysHistory> sysHistoriesMajor = sysHistoryService.selectSysHistoryMajor(stuId);
            request.setAttribute("sysHistoriesMajor", sysHistoriesMajor.get(0));
            //查询访问最多学校
            List<SysHistory> sysHistoriesUniversity = sysHistoryService.selectSysHistoryUniversity(stuId);
            request.setAttribute("sysHistoriesUniversity", sysHistoriesUniversity.get(0));
            //查询考生信息
            SysStudent sysStudentInfo = sysStudentService.selectSysStudentById(Long.parseLong(stuId));
            request.setAttribute("sysStudent", sysStudentInfo);
        }
        return "client/personal/welcome/welcome";
    }

    //历史访问记录
    @GetMapping("/history")
    @ResponseBody
    public List history(SysHistory sysPatients){
        List<SysHistory> sysHistories = sysHistoryService.selectSysHistoryList(sysPatients);
        return sysHistories;
    }

}
