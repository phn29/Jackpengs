package com.zyx.web.controller.client;

import com.zyx.common.annotation.Excel;
import com.zyx.common.core.domain.AjaxResult;
import com.zyx.common.core.domain.entity.*;
import com.zyx.system.domain.ResponseData;
import com.zyx.system.service.*;
import net.bytebuddy.asm.Advice;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/client/personal")
public class clientPersonalController {
    @Autowired
    private ISysChatService sysChatService;
    @Autowired
    private ISysHistoryService sysHistoryService;
    @Autowired
    private ISysStudentService sysStudentService;
    @Autowired
    private ISysVolunteerService sysVolunteerService;
    @Autowired
    private ISysCollectionService sysCollectionService;
    @Autowired
    private ISysMajorService sysMajorService;
    @Autowired
    private ISysUniversityService sysUniversityService;
    @Autowired
    private ISysResultService sysResultService;

    //跳转个人中心-首页
    @GetMapping("/index")
    public String pIndex(HttpSession session, HttpServletRequest request){
        if(session.getAttribute("SysStudent") == null && session.getAttribute("SysExpert") == null){
            return "redirect:/client/login";
        }

        //考生个人资料数据回显
        SysStudent sysStudent = (SysStudent) session.getAttribute("SysStudent");
        if(!Objects.isNull(sysStudent)){
            Long stuId = sysStudent.getStuId();
            //考生个人资料数据回显
            SysStudent sysStudents = sysStudentService.selectSysStudentById(stuId);
            request.setAttribute("SysStudent", sysStudents);
            //查询考生志愿
            SysVolunteer sysVolunteer = new SysVolunteer();
            sysVolunteer.setStuId(sysStudent.getStuId().toString());
            List<SysVolunteer> volunteerList = sysVolunteerService.selectSysVolunteerList(sysVolunteer);
            request.setAttribute("SysVolunteer", volunteerList);
            //查询考生专家
            List<SysChat> sysChats = sysChatService.selectMyself(sysStudent.getStuId().toString(), "");
            request.setAttribute("SysChat", sysChats);
            //查询考生收藏院校和专业
            SysCollection sysCollection = new SysCollection();
            sysCollection.setStuId(stuId);
            //专业
            sysCollection.setCollectionType("0");
            List<SysCollection> SysMajorCollection = sysCollectionService.selectSysCollectionList(sysCollection);
            request.setAttribute("SysMajorCollection", SysMajorCollection);
            //院校
            sysCollection.setCollectionType("1");
            List<SysCollection> SysUniversityCollection = sysCollectionService.selectSysCollectionList(sysCollection);
            request.setAttribute("SysUniversityCollection", SysUniversityCollection);
            //查询考生历史访问记录
            SysHistory sysHistory = new SysHistory();
            sysHistory.setUserId(stuId);
            List<SysHistory> sysHistories = sysHistoryService.selectSysHistoryList(sysHistory);
            request.setAttribute("SysHistory", sysHistories);
            //查询心理测试结果
            SysResult sysResult = sysResultService.selectSysResultById(sysStudents.getMbtiResult());
            if (!Objects.isNull(sysResult)) {
                request.setAttribute("SysResult", sysResult);
            } else {
                String str = "您还未进行心理测试，请先进行心理测试！";
                sysResult.setResultId(str);
                sysResult.setResultType(str);
                sysResult.setResultNature(str);
                sysResult.setNatureInfo(str);
                sysResult.setMajorType(str);
                sysResult.setUniversityType(str);
                request.setAttribute("SysResult", sysResult);
            }
        }

        return "client/personal/index";
    }

    //个人信息保存
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult save(SysStudent sysStudent, HttpSession session) throws IOException, ParseException {
        //考生个人资料数据回显
        SysStudent studentSession = (SysStudent) session.getAttribute("SysStudent");
        if(Objects.nonNull(studentSession)){
            return AjaxResult.success(sysStudentService.updateSysStudent(sysStudent));
        }
        return AjaxResult.error("个人信息保存编辑失败！");
    }

    //删除志愿
    @PostMapping("/delVolunteer")
    @ResponseBody
    public ResponseData delVolunteer(Long volunteerId, HttpSession session){
        //判断考生是否登录
        SysStudent studentSession = (SysStudent) session.getAttribute("SysStudent");
        if(Objects.nonNull(studentSession)){
            int i = sysVolunteerService.deleteSysVolunteerById(volunteerId);
            if(i != 0){
                return ResponseData.ok("删除成功！");
            }
            return ResponseData.fail("删除失败");
        }
        return ResponseData.fail("删除失败");
    }

    //删除专家
    @PostMapping("/delChat")
    @ResponseBody
    public ResponseData delChat(Long chatId, HttpSession session){
        //判断考生是否登录
        SysStudent studentSession = (SysStudent) session.getAttribute("SysStudent");
        if(Objects.nonNull(studentSession)){
            int i = sysChatService.deleteSysChatById(chatId);
            if(i != 0){
                return ResponseData.ok("删除成功！");
            }
            return ResponseData.fail("删除失败");
        }
        return ResponseData.fail("删除失败");
    }

    //删除院校收藏记录
    @PostMapping("/delCollectionUniversity")
    @ResponseBody
    public ResponseData delCollectionUniversity(String id, HttpSession session){
        //判断考生是否登录
        SysStudent studentSession = (SysStudent) session.getAttribute("SysStudent");
        if(Objects.nonNull(studentSession)){
            int i = sysCollectionService.deleteSysCollectionById(Long.parseLong(id));
            if(i != 0){
                return ResponseData.ok("删除成功！");
            }
            return ResponseData.fail("删除失败");
        }
        return ResponseData.fail("删除失败");
    }

    //删除专业收藏记录
    @PostMapping("/delCollectionMajor")
    @ResponseBody
    public ResponseData delCollectionMajor(String id, HttpSession session){
        //判断考生是否登录
        SysStudent studentSession = (SysStudent) session.getAttribute("SysStudent");
        if(Objects.nonNull(studentSession)){
            int i = sysCollectionService.deleteSysCollectionById(Long.parseLong(id));
            if(i != 0){
                return ResponseData.ok("删除成功！");
            }
            return ResponseData.fail("删除失败");
        }
        return ResponseData.fail("删除失败");
    }

    //历史记录删除
    @PostMapping("/delHistory")
    @ResponseBody
    public ResponseData delHistory(String historyId, HttpSession session){
        //判断考生是否登录
        SysStudent studentSession = (SysStudent) session.getAttribute("SysStudent");
        if(Objects.nonNull(studentSession)){
            int i = sysHistoryService.deleteSysHistoryById(Long.parseLong(historyId));
            if(i != 0){
                return ResponseData.ok("删除成功！");
            }
            return ResponseData.fail("删除失败");
        }
        return ResponseData.fail("删除失败");
    }

    //志愿分析
    @GetMapping("/analysis/{volunteerId}")
    public String analysis(@PathVariable("volunteerId") Long volunteerId, Model model){
        //存放结果实体
        SysAnalysis sysAnalysis = new SysAnalysis();
        //获取当前志愿信息
        SysVolunteer sysVolunteer = sysVolunteerService.selectSysVolunteerById(volunteerId);
        //获取当前考生信息
        SysStudent sysStudent = sysStudentService.selectSysStudentById(Long.parseLong(sysVolunteer.getStuId()));
        //计算录取概率

        //目标地域分析
        String[] address = new String[3];
        address[0] = sysStudent.getPurposeAddressOne();
        address[1] = sysStudent.getPurposeAddressTwo();
        address[2] = sysStudent.getPurposeAddressThree();
        for (int i = 0; i < address.length; i++) {
            if(address[i].equals(sysVolunteer.getUniversity().getProvinceName())){
                String str = "您所选的填报的院校所属省份为："+sysVolunteer.getUniversity().getProvinceName()+"符合您的第"+address.length+"目标地域";
                sysAnalysis.setAddressInfo(str);
                break;
            }else{
                String str = "您所选的填报的院校所属省份为："+sysVolunteer.getUniversity().getProvinceName()+"与您的意向地区不符合";
                sysAnalysis.setAddressInfo(str);
            }
        }
        //目标专业分析
        String[] majors = new String[3];
        majors[0] = sysStudent.getPurposeMajorOne();
        majors[1] = sysStudent.getPurposeMajorTwo();
        majors[2] = sysStudent.getPurposeMajorThree();
        //判断考生所填报的志愿专业和意向是否一样
        for (int i = 0; i < majors.length; i++) {
            //查询考生所目标专业的专业类型
            SysMajor sysMajor = sysMajorService.selectSysMajorByMajorName(majors[i]);
            //判断专业名称是否一样
            if(majors[i].equals(sysVolunteer.getMajorName())){
                String str = "您所选的填报的专业为："+sysVolunteer.getMajorName()+"，与您的意向"+majors.length+"专业名称相符";
                sysAnalysis.setMajorInfo(str);
                break;
            }else if(!majors[i].equals(sysVolunteer.getMajorName())){
                //判断专业类型是否一样
                if(sysMajor.getMajorType().equals(sysVolunteer.getMajor().getMajorType())){
                    String str = "您所选的填报的专业为："+sysVolunteer.getMajorName()+"专业，与您的意向"+majors.length+
                            "专业类型是相符合的，都属于："+sysVolunteer.getMajor().getMajorType();
                    sysAnalysis.setMajorInfo(str);
                    break;
                }else{
                    String str = "您所选的填报的专业为："+sysVolunteer.getMajorName()+"专业，不符合您的目标专业，也非您的目标近似专业";
                    sysAnalysis.setMajorInfo(str);
                }
            }
        }
        //院校分析
        SysResult sysResult = sysResultService.selectSysResultById(sysStudent.getMbtiResult());
        String universityTypeStr = sysResult.getUniversityType();
        String[] universityTypeArray = universityTypeStr.split("、");
        for (int i = 0; i < universityTypeArray.length; i++) {
            if (universityTypeArray[i].equals(sysVolunteer.getUniversity().getUniversityType())) {
                String strOne = "通过心理测试为你推荐的院校类型为："+universityTypeStr;
                String strTwo = "您所填报的"+sysVolunteer.getUniversityName()+"为"+sysVolunteer.getUniversity().getUniversityType()+"符合您为你推荐的院校类型";
                sysAnalysis.setMbtiInfo(strOne + strTwo);
                break;
            }else{
                String strOne = "通过心理测试为你推荐的院校类型为："+universityTypeStr;
                String strTwo = "您所填报的"+sysVolunteer.getUniversityName()+"为"+sysVolunteer.getUniversity().getUniversityType()+"不符合您为你推荐的院校类型";
                sysAnalysis.setMbtiInfo(strOne + strTwo);
            }
        }

        //院校级别
        sysAnalysis.setUniversityLevel("该院校级别为："+sysVolunteer.getUniversity().getUniversityLevel());
        //专业级别和修学年限
        sysAnalysis.setMajorLevel("该专业为："+sysVolunteer.getMajor().getMajorLevel()+"专业，修学年限为："+sysVolunteer.getMajor().getStudyYears());
        //综合评定
        model.addAttribute("sysAnalysis", sysAnalysis);
        return "client/personal/analysis";
    }

//    //跳转到我的专家页面
//    @GetMapping("/expertList")
//    public String expertList(HttpServletRequest request, HttpSession session){
//        SysStudent sysStudent = (SysStudent) session.getAttribute("SysStudent");
//        if(sysStudent != null){
//            String stuId = sysStudent.getStuId().toString();
//            //查询用户的咨询师
//            List<SysChat> sysChats = sysChatService.selectMyself(stuId, "");
//            request.setAttribute("sysChats", sysChats);
//        }
//        return "client/personal/expert/expert_list";
//    }
//
//    //跳转我的考生页面
//    @GetMapping("/stuList")
//    public String stuList(HttpServletRequest request, HttpSession session){
//        SysExpert sysExpert = (SysExpert) session.getAttribute("SysExpert");
//        //查询咨询师的用户
//        if(sysExpert != null){
//            //拼接考生选科
//
//            String expertId = sysExpert.getExpertId().toString();
//            List<SysChat> sysChats = sysChatService.selectMyself("", expertId);
//            request.setAttribute("sysChats", sysChats);
//        }
//        return "client/personal/student/student_list";
//    }
//
//    //删除我的专家||我的学生
//    @PostMapping("/chatDel")
//    @ResponseBody
//    public ResponseData delete(Long chatId){
//        sysChatService.deleteSysChatById(chatId);
//        return ResponseData.ok("已删除");
//    }
//
//    //跳转历史记录页面
//    @GetMapping("/historyList")
//    public String historyList(HttpServletRequest request, HttpSession session){
//        SysStudent sysStudent = (SysStudent) session.getAttribute("SysStudent");
//        SysHistory sysHistory = new SysHistory();
//        sysHistory.setUserId(sysStudent.getStuId());
//        List<SysHistory> sysHistories = sysHistoryService.selectSysHistoryList(sysHistory);
//        request.setAttribute("sysHistories", sysHistories);
//        return "client/personal/history/history_list";
//    }
//
//    //删除历史记录
//    @PostMapping("/historyDel")
//    @ResponseBody
//    public ResponseData delHistory(Long historyId){
//        sysHistoryService.deleteSysHistoryById(historyId);
//        return ResponseData.ok("已删除");
//    }
//
//    //跳转志愿管理页面
//    @GetMapping("/volunteerList")
//    public String volunteerList(HttpServletRequest request, SysVolunteer sysVolunteer, HttpSession session){
//        SysStudent sysStudent = (SysStudent) session.getAttribute("SysStudent");
//        sysVolunteer.setStuId(sysStudent.getStuId().toString());
//        List<SysVolunteer> volunteerList = sysVolunteerService.selectSysVolunteerList(sysVolunteer);
//        request.setAttribute("volunteerList", volunteerList);
//        return "client/personal/volunteer/volunteer_list";
//    }
//
//    //删除我的志愿
//    @PostMapping("/volunteerDel")
//    @ResponseBody
//    public ResponseData delVolunteer(Long volunteerId){
//        try {
//            sysVolunteerService.deleteSysVolunteerById(volunteerId);
//            return ResponseData.ok("已删除");
//        }catch (Exception e){
//            return ResponseData.fail();
//        }
//    }
//
//    //跳转到修改个人信息页面
//    @GetMapping("/editPersonal")
//    public String editPersonal(){
//        return "client/personal/index/personal_info";
//    }




//    //跳转我的页面
//    @GetMapping("/personal")
//    public String Personal(HttpServletRequest request, HttpSession session){
//        //查询用户的咨询师
//        SysStudent sysStudent = (SysStudent) session.getAttribute("SysStudent");
//        SysExpert sysExpert = (SysExpert) session.getAttribute("SysExpert");
//        String stuId = sysStudent.getStuId().toString();
//        String expertId = sysStudent.getStuId().toString();
//        if(sysStudent != null){
//            //查询用户的咨询师
//            List<SysChat> sysChats = sysChatService.selectMyself(stuId, "");
//
//            request.setAttribute("sysChats", sysChats);
//            //查询访问最多专业
//            List<SysHistory> sysHistoriesMajor = sysHistoryService.selectSysHistoryMajor(stuId);
//            request.setAttribute("sysHistoriesMajor", sysHistoriesMajor);
//            //查询访问最多学校
//            List<SysHistory> sysHistoriesUniversity = sysHistoryService.selectSysHistoryUniversity(stuId);
//            request.setAttribute("sysHistoriesUniversity", sysHistoriesUniversity);
//
//        }
//        //查询咨询师的用户
//        if(sysExpert != null){
//            List<SysChat> sysChats = sysChatService.selectMyself("", expertId);
//            request.setAttribute("sysChats", sysChats);
//        }
//        return "client/personal/personal_info";
//    }



//    //查询用户当前的咨询师，查询咨询师当前的用户
//    @PostMapping("/selectUser")
//    public


}
