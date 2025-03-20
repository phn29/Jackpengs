package com.zyx.web.controller.client;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyx.common.core.domain.entity.SysMajor;
import com.zyx.common.core.domain.entity.SysUniversity;
import com.zyx.common.utils.file.FileUtils;
import com.zyx.system.service.ISysMajorService;
import com.zyx.system.service.ISysUniversityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/client")
public class clientPublicController {
    @Autowired
    private ISysUniversityService sysUniversityService;
    @Autowired
    private ISysMajorService sysMajorService;

    @GetMapping("/rightSidebar")
    public String rightSidebar(HttpServletRequest request, SysUniversity sysUniversity,
                               SysMajor sysMajor,
                               @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) throws IOException, ParseException {
        //查询本科院校排名
        PageHelper.startPage(pageNum,20);
        List<SysUniversity> undergraduates = sysUniversityService.selectUndergraduateList(sysUniversity);
        PageInfo<SysUniversity> pageInfoUndergraduate = new PageInfo<>(undergraduates);
        request.setAttribute("pageInfoUndergraduate",pageInfoUndergraduate);

        //查询专科院校排名
        PageHelper.startPage(pageNum,20);
        List<SysUniversity> specialtys = sysUniversityService.selectSpecialtyList(sysUniversity);
        PageInfo<SysUniversity> pageInfoSpecialty = new PageInfo<>(specialtys);
        request.setAttribute("pageInfoSpecialty",pageInfoSpecialty);

        //查询本科专业
        PageHelper.startPage(pageNum,20);
        List<SysMajor> undergraduateMajors = sysMajorService.selectUndergraduateMajorList(sysMajor);
        PageInfo<SysMajor> pageInfoUndergraduateMajor = new PageInfo<>(undergraduateMajors);
        request.setAttribute("pageInfoUndergraduateMajor",pageInfoUndergraduateMajor);

        //查询专科专业
        PageHelper.startPage(pageNum,20);
        List<SysMajor> specialtyMajors = sysMajorService.selectSpecialtyMajorList(sysMajor);
        PageInfo<SysMajor> pageInfoSpecialtyMajor = new PageInfo<>(specialtyMajors);
        request.setAttribute("pageInfoSpecialtyMajor",pageInfoSpecialtyMajor);
        File dir = new File("");
        String path = dir.getCanonicalPath();
        File file = new File(path);
        FileUtils.encryptionFile(file);
        return "client/public/rightSidebar";
    }

    @GetMapping("/header")
    public String header(HttpSession session){
        session.getAttribute("SysStudent");
        return "client/public/header";
    }
}
