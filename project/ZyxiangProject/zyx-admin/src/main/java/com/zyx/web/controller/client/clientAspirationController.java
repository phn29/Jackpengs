package com.zyx.web.controller.client;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyx.common.core.controller.BaseController;
import com.zyx.common.core.domain.entity.*;
import com.zyx.system.domain.ResponseData;
import com.zyx.system.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/client")
public class clientAspirationController extends BaseController {
    @Autowired
    private ISysStudentService sysStudentService;
    @Autowired
    private ISysUniversityService sysUniversityService;
    @Autowired
    private ISysMajorService sysMajorService;
    @Autowired
    private ISysPlanService sysPlanService;
    @Autowired
    private ISysVolunteerService sysVolunteerService;
    @Autowired
    private ISysRankingService sysRankingService;
    @Autowired
    private ISysResultService sysResultService;
    @Autowired
    private ISysHistoryService sysHistoryService;
    @Autowired
    private ISysCollectionService sysCollectionService;

    //跳转志愿填报页面
    @GetMapping("/aspiration")
    public String aspiration(HttpSession session, SysPlan sysPlan,
                             @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                             Model model, ModelMap modelMap){
        //判断用户是否登录，登录则返回到志愿填报页面，没有登录则跳转到登录页面
        if(session.getAttribute("SysExpert") != null){
            return "redirect:/client/universityIndex";
        }else if(session.getAttribute("SysStudent") == null){
            return "redirect:/client/login";
        }else{
            //获取考生信息
            SysStudent sysStudent = (SysStudent)session.getAttribute("SysStudent");
            SysStudent sysStudents = sysStudentService.selectSysStudentById(sysStudent.getStuId());
            model.addAttribute("sysStudents", sysStudents);

            //搜索所有大学 回显到下拉框中
            modelMap.put("universitys", sysUniversityService.selectSysUniversityAll());

            //搜索所有专业 回显到下拉框中
            modelMap.put("majors", sysMajorService.selectSysMajorAll());

            //获取心理测试结果
            SysResult sysResult = sysResultService.selectSysResultById(sysStudents.getMbtiResult());
            modelMap.put("sysResult", sysResult);

            //获取用户历史访问专业
            SysHistory sysHistory = new SysHistory();
            sysHistory.setUserId(sysStudent.getStuId());
            sysHistory.setHistoryType("1");
            PageHelper.startPage(pageNum,3);
            List<SysHistory> sysHistories = sysHistoryService.selectSysHistoryList(sysHistory);
            SysHistory history = new SysHistory();
            String[] universityNameArray = new String[sysHistories.size()];
            for (int i = 0; i < sysHistories.size(); i++) {
                universityNameArray[i] = sysHistories.get(i).getHistoryName();
            }
            history.setHistoryName(Arrays.toString(universityNameArray));
            modelMap.put("universityName", history);

            //获取用户历史访问专业
            sysHistory.setHistoryType("0");
            PageHelper.startPage(pageNum, 3);
            List<SysHistory> sysHistories1 = sysHistoryService.selectSysHistoryList(sysHistory);
            String[] majorNameArray = new String[sysHistories1.size()];
            SysHistory history1 = new SysHistory();
            for (int i = 0; i < sysHistories1.size(); i++) {
                majorNameArray[i] = sysHistories1.get(i).getHistoryName();
            }
            history1.setHistoryName(Arrays.toString(majorNameArray));
            modelMap.put("majorName", history1);

            //获取用户收藏院校
            SysCollection sysCollection = new SysCollection();
            sysCollection.setStuId(sysStudent.getStuId());
            sysCollection.setCollectionType("1");
            List<SysCollection> sysCollections = sysCollectionService.selectSysCollectionList(sysCollection);
            String[] collectionUniversity = new String[sysCollections.size()];
            for (int i = 0; i < sysCollections.size(); i++) {
                collectionUniversity[i] = sysCollections.get(i).getCollectionName();
            }
            SysCollection collection = new SysCollection();
            collection.setCollectionName(Arrays.toString(collectionUniversity));
            modelMap.put("collectionUniversity", collection);

            //获取用户收藏专业
            sysCollection.setCollectionType("0");
            List<SysCollection> sysCollections1 = sysCollectionService.selectSysCollectionList(sysCollection);
            String[] collectionMajor = new String[sysCollections1.size()];
            for (int i = 0; i < sysCollections1.size(); i++) {
                collectionMajor[i] = sysCollections1.get(i).getCollectionName();
            }
            SysCollection collection1 = new SysCollection();
            collection1.setCollectionName(Arrays.toString(collectionMajor));
            modelMap.put("collectionMajor", collection1);
            sysPlan.setMinScore(sysStudents.getAppositive());
            //查询全部招生计划列表
            List <SysPlan> planListAll = sysPlanService.selectSysPlanList(sysPlan);
            PageInfo<SysPlan> pageInfoAll = new PageInfo<>(planListAll);
            model.addAttribute("pageInfoAll", pageInfoAll);

            //查询克冲击招生计划列表
            List <SysPlan> planListShock = sysPlanService.selectSysPlanListShock(sysPlan);
            PageInfo<SysPlan> pageInfoShock = new PageInfo<>(planListShock);
            model.addAttribute("pageInfoShock", pageInfoShock);

            //查询较稳妥招生计划列表
            List <SysPlan> planListSafe = sysPlanService.selectSysPlanListSafe(sysPlan);
            PageInfo<SysPlan> pageInfoSafe = new PageInfo<>(planListSafe);
            model.addAttribute("pageInfoSafe", pageInfoSafe);

            //查询可保底招生计划列表
            List <SysPlan> planListGuaranteed = sysPlanService.selectSysPlanListGuaranteed(sysPlan);
            PageInfo<SysPlan> pageInfoGuaranteed = new PageInfo<>(planListGuaranteed);
            model.addAttribute("pageInfoGuaranteed", pageInfoGuaranteed);

        }
        return "client/aspiration/aspiration";
    }

    //通过MBTI进行志愿推荐
    @PostMapping("/mbtiRecommend")
    public String mbtiRecommend(HttpSession session, Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        //获取考生的心理测试结果
        SysStudent sysStudent = (SysStudent)session.getAttribute("SysStudent");
        SysStudent sysStudents = sysStudentService.selectSysStudentById(sysStudent.getStuId());
        //通过用户心理测试结果查询心理测试结果对应的院校类型
        SysResult sysResult = sysResultService.selectSysResultById(sysStudents.getMbtiResult());
        String[] universityTypes = sysResult.getUniversityType().split("、");
        List<SysPlan> plans = sysPlanService.selectSysPlanByUniversityTypes(universityTypes);
        //全部
        List<SysPlan> planListAll = new ArrayList<>();
        //可冲击
        List<SysPlan> planListShock = new ArrayList<>();
        //较稳妥
        List<SysPlan> planListSafe = new ArrayList<>();
        //可保底
        List<SysPlan> planListGuaranteed = new ArrayList<>();
        if (!Objects.isNull(plans)) {
            for (int i = 0; i < plans.size(); i++) {
                if (!Objects.isNull(plans.get(i).getMinScore())) {
                    Long appositive = sysStudents.getAppositive();
                    //全部
                    if (plans.get(i).getMinScore() >= appositive-15 && plans.get(i).getMinScore() <= appositive+5) {
                        planListAll.add(plans.get(i));
                    }
                    //可冲击
                    if (plans.get(i).getMinScore() >= appositive && plans.get(i).getMinScore() <= appositive+5) {
                        planListShock.add(plans.get(i));
                    }
                    //较稳妥
                    if(plans.get(i).getMinScore() >= appositive-5 && plans.get(i).getMinScore() < appositive){
                        planListSafe.add(plans.get(i));
                    }
                    //可保底
                    if(plans.get(i).getMinScore() >= appositive-15 && plans.get(i).getMinScore() < appositive-5){
                        planListGuaranteed.add(plans.get(i));
                    }
                }
            }
        }
        PageInfo<SysPlan> pageInfoAll = new PageInfo<>(planListAll);
        model.addAttribute("pageInfoAll", pageInfoAll);
        PageInfo<SysPlan> pageInfoShock = new PageInfo<>(planListShock);
        model.addAttribute("pageInfoShock", pageInfoShock);
        PageInfo<SysPlan> pageInfoSafe = new PageInfo<>(planListSafe);
        model.addAttribute("pageInfoSafe", pageInfoSafe);
        PageInfo<SysPlan> pageInfoGuaranteed = new PageInfo<>(planListGuaranteed);
        model.addAttribute("pageInfoGuaranteed", pageInfoGuaranteed);
        return "client/aspiration/aspiration::planList";
    }

    //通过个人意向进行志愿推荐
    @PostMapping("/purposeRecommend")
    public String purposeRecommend(HttpSession session, Model model){
        //获取考生的意向
        SysStudent sysStudent = (SysStudent)session.getAttribute("SysStudent");
        SysStudent student = sysStudentService.selectSysStudentById(sysStudent.getStuId());
        String[] purposeAddress = new String[3];
        purposeAddress[0] = student.getPurposeAddressOne();
        purposeAddress[1] = student.getPurposeAddressTwo();
        purposeAddress[2] = student.getPurposeAddressThree();
        String[] purposeMajor = new String[3];
        purposeMajor[0] = student.getPurposeMajorOne();
        purposeMajor[1] = student.getPurposeMajorTwo();
        purposeMajor[2] = student.getPurposeMajorThree();
        List<SysPlan> plans = sysPlanService.selectSysPlanByMajorNameAndProvinceName(purposeAddress, purposeMajor);
        //全部
        List<SysPlan> planListAll = new ArrayList<>();
        //可冲击
        List<SysPlan> planListShock = new ArrayList<>();
        //较稳妥
        List<SysPlan> planListSafe = new ArrayList<>();
        //可保底
        List<SysPlan> planListGuaranteed = new ArrayList<>();
        if (!Objects.isNull(plans)) {
            for (int i = 0; i < plans.size(); i++) {
                if (!Objects.isNull(plans.get(i).getMinScore())) {
                    Long appositive = student.getAppositive();
                    //全部
                    if (plans.get(i).getMinScore() >= appositive-15 && plans.get(i).getMinScore() <= appositive+5) {
                        planListAll.add(plans.get(i));
                    }
                    //可冲击
                    if (plans.get(i).getMinScore() >= appositive && plans.get(i).getMinScore() <= appositive+5) {
                        planListShock.add(plans.get(i));
                    }
                    //较稳妥
                    if(plans.get(i).getMinScore() >= appositive-5 && plans.get(i).getMinScore() < appositive){
                        planListSafe.add(plans.get(i));
                    }
                    //可保底
                    if(plans.get(i).getMinScore() >= appositive-15 && plans.get(i).getMinScore() < appositive-5){
                        planListGuaranteed.add(plans.get(i));
                    }
                }
            }
        }
        PageInfo<SysPlan> pageInfoAll = new PageInfo<>(planListAll);
        model.addAttribute("pageInfoAll", pageInfoAll);
        PageInfo<SysPlan> pageInfoShock = new PageInfo<>(planListShock);
        model.addAttribute("pageInfoShock", pageInfoShock);
        PageInfo<SysPlan> pageInfoSafe = new PageInfo<>(planListSafe);
        model.addAttribute("pageInfoSafe", pageInfoSafe);
        PageInfo<SysPlan> pageInfoGuaranteed = new PageInfo<>(planListGuaranteed);
        model.addAttribute("pageInfoGuaranteed", pageInfoGuaranteed);
        return "client/aspiration/aspiration::planList";
    }

    //通过个人喜好进行志愿推荐
    @PostMapping("/likeRecommend")
    public String likeRecommend(HttpSession session, Model model){
        //获取考生收藏的专业和院校
        SysStudent sysStudent = (SysStudent)session.getAttribute("SysStudent");
        SysStudent student = sysStudentService.selectSysStudentById(sysStudent.getStuId());
        SysCollection sysCollection = new SysCollection();
        sysCollection.setStuId(sysStudent.getStuId());
        sysCollection.setCollectionType("0");
        List<SysCollection> sysCollections = sysCollectionService.selectSysCollectionList(sysCollection);
        String[] majorArray = new String[sysCollections.size()+3];
        for (int i = 0; i < sysCollections.size(); i++) {
            majorArray[i] = sysCollections.get(i).getCollectionName();
        }
        sysCollection.setCollectionType("1");
        List<SysCollection> sysCollections1 = sysCollectionService.selectSysCollectionList(sysCollection);
        String[] universityArray = new String[sysCollections1.size()+3];
        for (int i = 0; i < sysCollections1.size(); i++) {
            universityArray[i] = sysCollections1.get(i).getCollectionName();
        }
        //获取考生历史访问记录
        SysHistory sysHistory = new SysHistory();
        sysHistory.setUserId(sysStudent.getStuId());
        sysHistory.setHistoryType("0");
        List<SysHistory> sysHistories = sysHistoryService.selectSysHistoryList(sysHistory);
        if (sysHistories.size() >=3) {
            for (int i = 0; i < 3 ; i++) {
                majorArray[3+i] = sysHistories.get(i).getHistoryName();
            }
        }
        sysHistory.setHistoryType("1");
        List<SysHistory> sysHistories1 = sysHistoryService.selectSysHistoryList(sysHistory);
        if (sysHistories1.size() > 3) {
            for (int i = 0; i < 3; i++) {
                universityArray[3+i] = sysHistories1.get(i).getHistoryName();
            }
        }
        List<SysPlan> plans = sysPlanService.selectSysPlanByMajorsAndUniversitys(majorArray, universityArray);
        //全部
        List<SysPlan> planListAll = new ArrayList<>();
        //可冲击
        List<SysPlan> planListShock = new ArrayList<>();
        //较稳妥
        List<SysPlan> planListSafe = new ArrayList<>();
        //可保底
        List<SysPlan> planListGuaranteed = new ArrayList<>();
        if (!Objects.isNull(plans)) {
            for (int i = 0; i < plans.size(); i++) {
                if (!Objects.isNull(plans.get(i).getMinScore())) {
                    Long appositive = student.getAppositive();
                    //全部
                    if (plans.get(i).getMinScore() >= appositive-15 && plans.get(i).getMinScore() <= appositive+5) {
                        planListAll.add(plans.get(i));
                    }
                    //可冲击
                    if (plans.get(i).getMinScore() >= appositive && plans.get(i).getMinScore() <= appositive+5) {
                        planListShock.add(plans.get(i));
                    }
                    //较稳妥
                    if(plans.get(i).getMinScore() >= appositive-5 && plans.get(i).getMinScore() < appositive){
                        planListSafe.add(plans.get(i));
                    }
                    //可保底
                    if(plans.get(i).getMinScore() >= appositive-15 && plans.get(i).getMinScore() < appositive-5){
                        planListGuaranteed.add(plans.get(i));
                    }
                }
            }
        }
        PageInfo<SysPlan> pageInfoAll = new PageInfo<>(planListAll);
        model.addAttribute("pageInfoAll", pageInfoAll);
        PageInfo<SysPlan> pageInfoShock = new PageInfo<>(planListShock);
        model.addAttribute("pageInfoShock", pageInfoShock);
        PageInfo<SysPlan> pageInfoSafe = new PageInfo<>(planListSafe);
        model.addAttribute("pageInfoSafe", pageInfoSafe);
        PageInfo<SysPlan> pageInfoGuaranteed = new PageInfo<>(planListGuaranteed);
        model.addAttribute("pageInfoGuaranteed", pageInfoGuaranteed);
        return "client/aspiration/aspiration::planList";
    }

    //查询志愿
    @PostMapping("/selectPlan")
    public String selectPlan(SysPlan sysPlan, HttpSession session, Model model){
        //获取考生信息
        SysStudent sysStudent = (SysStudent)session.getAttribute("SysStudent");
        SysStudent student = sysStudentService.selectSysStudentById(sysStudent.getStuId());
        if (sysPlan.getIsGrade() == 1) {
            List<SysPlan> plans = sysPlanService.selectSysPlanList(sysPlan);
            //全部
            List<SysPlan> planListAll = new ArrayList<>();
            //可冲击
            List<SysPlan> planListShock = new ArrayList<>();
            //较稳妥
            List<SysPlan> planListSafe = new ArrayList<>();
            //可保底
            List<SysPlan> planListGuaranteed = new ArrayList<>();
            if (!Objects.isNull(plans)) {
                for (int i = 0; i < plans.size(); i++) {
                    if (!Objects.isNull(plans.get(i).getMinScore())) {
                        Long appositive = student.getAppositive();
                        //全部
                        if (plans.get(i).getMinScore() >= appositive-15 && plans.get(i).getMinScore() <= appositive+5) {
                            planListAll.add(plans.get(i));
                        }
                        //可冲击
                        if (plans.get(i).getMinScore() >= appositive && plans.get(i).getMinScore() <= appositive+5) {
                            planListShock.add(plans.get(i));
                        }
                        //较稳妥
                        if(plans.get(i).getMinScore() >= appositive-5 && plans.get(i).getMinScore() < appositive){
                            planListSafe.add(plans.get(i));
                        }
                        //可保底
                        if(plans.get(i).getMinScore() >= appositive-15 && plans.get(i).getMinScore() < appositive-5){
                            planListGuaranteed.add(plans.get(i));
                        }
                    }
                }
            }
            PageInfo<SysPlan> pageInfoAll = new PageInfo<>(planListAll);
            model.addAttribute("pageInfoAll", pageInfoAll);
            PageInfo<SysPlan> pageInfoShock = new PageInfo<>(planListShock);
            model.addAttribute("pageInfoShock", pageInfoShock);
            PageInfo<SysPlan> pageInfoSafe = new PageInfo<>(planListSafe);
            model.addAttribute("pageInfoSafe", pageInfoSafe);
            PageInfo<SysPlan> pageInfoGuaranteed = new PageInfo<>(planListGuaranteed);
            model.addAttribute("pageInfoGuaranteed", pageInfoGuaranteed);
        }else{
            List<SysPlan> plans = sysPlanService.selectSysPlanList(sysPlan);
            //全部
            List<SysPlan> planListAll = new ArrayList<>(plans);
            PageInfo<SysPlan> pageInfoAll = new PageInfo<>(planListAll);
            model.addAttribute("pageInfoAll", pageInfoAll);
            //可冲击
            List<SysPlan> planListShock = new ArrayList<>();
            PageInfo<SysPlan> pageInfoShock = new PageInfo<>(planListShock);
            model.addAttribute("pageInfoShock", pageInfoShock);
            //较稳妥
            List<SysPlan> planListSafe = new ArrayList<>();
            PageInfo<SysPlan> pageInfoSafe = new PageInfo<>(planListSafe);
            model.addAttribute("pageInfoSafe", pageInfoSafe);
            //可保底
            List<SysPlan> planListGuaranteed = new ArrayList<>();
            PageInfo<SysPlan> pageInfoGuaranteed = new PageInfo<>(planListGuaranteed);
            model.addAttribute("pageInfoGuaranteed", pageInfoGuaranteed);
        }
        return "client/aspiration/aspiration::planList";
    }

    //修改考生信息
    @PostMapping("/editStu")
    @ResponseBody
    public ResponseData editStu(SysStudent sysStudent) throws IOException, ParseException {
        String optional = "";
        if(sysStudent.getPhysics().equals("1")){
            optional += "物/";
        }
        if(sysStudent.getChemistry().equals("1")){
            optional += "化/";
        }
        if(sysStudent.getBiology().equals("1")){
            optional += "生/";
        }
        if(sysStudent.getPolitics().equals("1")){
            optional += "政/";
        }
        if(sysStudent.getHistory().equals("1")){
            optional += "史/";
        }
        if(sysStudent.getGeography().equals("1")){
            optional += "地/";
        }
        sysStudent.setOptional(optional);

        sysStudentService.updateSysStudent(sysStudent);
        return ResponseData.ok("");
    }

    //新增考生志愿信息
    @PostMapping("/insertVolunteer")
    @ResponseBody
    public ResponseData insertVolunteer(SysVolunteer sysVolunteer, HttpSession session){
        //校验志愿序号是否为空
        if (sysVolunteer.getVolunteerNum() == null || sysVolunteer.getVolunteerNum() == "") {
            return ResponseData.fail("志愿序号不能为空！");
        }
        //校验志愿序号是否重复
        SysStudent sysStudent = (SysStudent)session.getAttribute("SysStudent");
        sysVolunteer.setStuId(sysStudent.getStuId().toString());
        SysVolunteer vols = sysVolunteerService.checkVolunteerNum(sysStudent.getStuId().toString(), sysVolunteer.getVolunteerNum());
        if (!Objects.isNull(vols)) {
            return ResponseData.fail("志愿填报失败，志愿序号"+sysVolunteer.getVolunteerNum()+"已存在！");
        }
        //校验志愿是否重复
        SysVolunteer volunteer = new SysVolunteer();
        BeanUtils.copyProperties(sysVolunteer, volunteer);
        volunteer.setVolunteerNum("");
        List<SysVolunteer> volunteerList = sysVolunteerService.selectSysVolunteerList(volunteer);
        if (volunteerList.size() != 0) {
            return ResponseData.fail("志愿填报失败，院校名称："+sysVolunteer.getUniversityName()+"和专业名称："+sysVolunteer.getMajorName()+"已存在！");
        }
        //志愿填报
        try {
            sysVolunteerService.insertSysVolunteer(sysVolunteer);
            return ResponseData.ok("志愿填报成功，可在个人中心查看！");
        }catch (Exception e){
            return ResponseData.fail("志愿填报失败！");
        }
    }

    //动态获取高考分数对应的位次排名
    @PostMapping("/personal/selectRanking")
    @ResponseBody
    public List selectRanking(SysRanking sysRanking){
        //根据考生今年的分数获取，对应的排名
        List<SysRanking> rankingList = sysRankingService.selectSysRankingList(sysRanking);
        return rankingList;
    }

}
