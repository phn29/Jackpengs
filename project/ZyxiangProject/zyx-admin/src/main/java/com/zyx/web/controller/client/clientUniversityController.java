package com.zyx.web.controller.client;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyx.common.core.domain.entity.SysHistory;
import com.zyx.common.core.domain.entity.SysPlan;
import com.zyx.common.core.domain.entity.SysUniversity;
import com.zyx.system.domain.ResponseData;
import com.zyx.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class clientUniversityController {

    @Autowired
    private ISysUniversityService sysUniversityService;
    @Autowired
    private ISysPlanService sysPlanService;
    @Autowired
    private ISysMajorService majorService;
    @Autowired
    private ISysHistoryService sysHistoryService;

    //跳转查学校页面
    @GetMapping("/selectUniversity")
    public String selectUniversity(Model model, SysUniversity sysUniversity, ModelMap maap,
                                   @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum)
    {
        maap.put("universitys", sysUniversityService.selectSysUniversityAll());
        //获取大学所在省份
        maap.put("provinceName", sysUniversityService.selectGroupByProvinceName(sysUniversity));
        PageHelper.startPage(pageNum,14);
        //获取正规大学信息列表
        List<SysUniversity> universities = sysUniversityService.selectUniversityZg(sysUniversity);
        PageInfo<SysUniversity> pageInfo = new PageInfo<>(universities);
        model.addAttribute("pageInfo", pageInfo);

        return "client/university/university_list";
    }

    //搜学校列表
    @PostMapping("/selectUniversity")
    public String selectUniversityList(SysUniversity sysUniversity, Model model, ModelMap maap,
                         @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum)
    {
        maap.put("universitys", sysUniversityService.selectSysUniversityAll());
        //获取大学所在省份
        maap.put("provinceName", sysUniversityService.selectGroupByProvinceName(sysUniversity));
        PageHelper.startPage(pageNum, 14);
        //获取正规大学信息列表
        List<SysUniversity> list = sysUniversityService.selectUniversityZg(sysUniversity);
        PageInfo<SysUniversity> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "client/university/university_list::universityList";
    }

    //跳转大学详情页面
    @GetMapping("/universityDetail/{universityId}")
    public String universityDetail(@PathVariable("universityId") Long universityId, Model model, ModelMap modelMap,
                                    SysPlan sysPlan,
                                   @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){

        SysUniversity universitydetail = sysUniversityService.selectSysUniversityById(universityId);
        model.addAttribute("SysUniversity",universitydetail);

        //查询专业将数据回显到下拉框中
        modelMap.put("majors", majorService.selectSysMajorAll());
        //查询大学历年招生计划
        PageHelper.startPage(pageNum, 10);
        sysPlan.setUniversityName(universitydetail.getUniversityName());
        List<SysPlan> listPlan = sysPlanService.selectSysPlanList(sysPlan);
        PageInfo<SysPlan> planListPageInfo = new PageInfo<>(listPlan);
        model.addAttribute("planListPageInfo", planListPageInfo);
        //访问记录加一
        SysUniversity sysUniversity = new SysUniversity();
        sysUniversity.setUniversityId(universityId);
        Integer visitNumber = universitydetail.getVisitNumber() + 1;
        sysUniversity.setVisitNumber(visitNumber);
        sysUniversityService.updateSysUniversity(sysUniversity);
        return "client/university/university_info";
    }

    //查询大学历年招生计划及录取分数
    @PostMapping("/universityDetail/plan/{universityId}")
    public String universityDetailPlane(@PathVariable("universityId") Long universityId, Model model, ModelMap modelMap,
                                        SysPlan sysPlan,
                                        @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        SysUniversity universitydetail = sysUniversityService.selectSysUniversityById(universityId);
        model.addAttribute("SysUniversity",universitydetail);
        //查询所有专业
        modelMap.put("majors", majorService.selectSysMajorAll());
        //查询大学历年招生计划
        PageHelper.startPage(pageNum, 10);
        sysPlan.setUniversityName(universitydetail.getUniversityName());
        List<SysPlan> listPlan = sysPlanService.selectSysPlanList(sysPlan);
        PageInfo<SysPlan> planListPageInfo = new PageInfo<>(listPlan);
        model.addAttribute("planListPageInfo", planListPageInfo);
        return "client/university/university_info :: planList";
    }

    //历年招生计划数据可视化
    @RequestMapping(value = "universityDetail/{universityId}/plan",method = RequestMethod.GET)
    @ResponseBody
    public List<SysPlan> showPlanData(@PathVariable("universityId") Long universityId){
        List<SysPlan> plans = sysPlanService.selectSysPlanByUniversityId(universityId);
        return plans;
    }

    //记录用户访问学校的次数
    @PostMapping("/universityHistory/add")
    @ResponseBody
    public ResponseData universityHistory(SysHistory sysHistory){
        try {
            sysHistoryService.insertSysHistory(sysHistory);
            return ResponseData.ok("");
        }catch (Exception e){
            return ResponseData.fail();
        }
    }

}
