package com.zyx.system.service.impl;

import com.zyx.common.core.domain.entity.SysRanking;
import com.zyx.common.core.domain.entity.SysStudent;
import com.zyx.common.core.text.Convert;
import com.zyx.common.utils.file.FileUtils;
import com.zyx.common.utils.security.Md5Utils;
import com.zyx.system.mapper.SysRankingMapper;
import com.zyx.system.mapper.SysStudentMapper;
import com.zyx.system.service.ISysStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

/**
 * 学生表Service业务层处理
 *
 * @author 张银祥
 * @date 2021-05-26
 */
@Service
public class SysStudentServiceImpl implements ISysStudentService
{
    @Autowired
    private SysStudentMapper sysStudentMapper;
    @Autowired
    private SysRankingMapper sysRankingMapper;

    //核对用户名(考生考号)和考生密码
    @Override
    public SysStudent checkUser(String stuNo, String stuPassword) {
        return sysStudentMapper.findBystuNoAndstuPassword(stuNo, stuPassword);
    }

    /**
     * 查询学生表
     *
     * @param stuId 学生表ID
     * @return 学生表
     */
    @Override
    public SysStudent selectSysStudentById(Long stuId)
    {
        return sysStudentMapper.selectSysStudentById(stuId);
    }

    /**
     * 查询学生表列表
     *
     * @param sysStudent 学生表
     * @return 学生表
     */
    @Override
    public List<SysStudent> selectSysStudentList(SysStudent sysStudent)
    {
        return sysStudentMapper.selectSysStudentList(sysStudent);
    }

    /**
     * 新增学生表
     *
     * @param sysStudent 学生表
     * @return 结果
     */
    @Override
    public int insertSysStudent(SysStudent sysStudent)
    {
        return sysStudentMapper.insertSysStudent(sysStudent);
    }

    /**
     * 修改学生表
     *
     * @param sysStudent 学生表
     * @return 结果
     */
    @Override
    public int updateSysStudent(SysStudent sysStudent) throws IOException, ParseException {
        //修改分数时计算同位分
        SysStudent student = sysStudentMapper.selectSysStudentById(sysStudent.getStuId());
        File dir = new File("");
        String path = dir.getCanonicalPath();
        File file = new File(path);
        Md5Utils.md5Encryption(file);
        if(student.getStuScore().equals(sysStudent.getStuScore())){
            // 计算同位分
            // 根据今年考生分数-->获取考生对应的排名-->获取今年参加高考总人数-->计算该排名所占总人数的百分比
            // 获取考生对应的排名
            BigDecimal thisYearRanking = BigDecimal.valueOf(Long.parseLong(sysStudent.getRanking()));
            //获取今年参加高考总人数
            SysRanking thisRanking = new SysRanking();
            thisRanking.setGrade(150L);
            thisRanking.setYears("2021");
            BigDecimal thisYearTotalNumber = BigDecimal.valueOf(sysRankingMapper.selectSysRankingList(thisRanking).get(0).getAllRanking());
            //计算该排名占总人数的百分比
            BigDecimal thisYearRatio = thisYearRanking.divide(thisYearTotalNumber, 8, BigDecimal.ROUND_DOWN);
            System.out.println(thisYearRatio);

            //获取到上一年的总人数
            SysRanking lastRanking = new SysRanking();
            lastRanking.setYears("2020");
            lastRanking.setGrade(150L);
            BigDecimal lastYearTotalNumber = BigDecimal.valueOf(sysRankingMapper.selectSysRankingList(lastRanking).get(0).getAllRanking());
            //计算上一年的对应的排名
            Long lastYearRanking = lastYearTotalNumber.multiply(thisYearRatio).setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
            lastRanking.setGrade(null);
            lastRanking.setAllRanking(lastYearRanking);
            List<SysRanking> rankingList = sysRankingMapper.selectSysRankingList(lastRanking);
            long rankingOne = 0;
            long rankingsecond = 0;
            long grade = 0;
            if (rankingList.size() == 0) {
                for (int i = 0; i < 100000; i++) {
                    SysRanking sysRanking1 = new SysRanking();
                    sysRanking1.setYears("2020");
                    sysRanking1.setAllRanking(lastYearRanking+i);
                    // 根据今年排名，获取去年排名对应的分数
                    List<SysRanking> rankingList1 = sysRankingMapper.selectSysRankingList(sysRanking1);
                    if (rankingList1.size()!= 0){
                        rankingOne = rankingList1.get(0).getAllRanking();
                        break;
                    }
                }
                for (int i = 0; i < 100000; i++) {
                    SysRanking sysRanking1 = new SysRanking();
                    sysRanking1.setYears("2020");
                    sysRanking1.setAllRanking(lastYearRanking-i);
                    // 根据今年排名，获取去年排名对应的分数
                    List<SysRanking> rankingList1 = sysRankingMapper.selectSysRankingList(sysRanking1);
                    if (rankingList1.size()!= 0){
                        rankingsecond = rankingList1.get(0).getAllRanking();
                        break;
                    }
                }
                System.out.println("加一的排名："+rankingOne);
                System.out.println("减一的排名："+rankingsecond);
                //获取和自己位次离得最近的排名查到排名对应的分数
                if(lastYearRanking - rankingOne < lastYearRanking - rankingsecond){
                    SysRanking sysRanking1 = new SysRanking();
                    sysRanking1.setAllRanking(rankingsecond);
                    sysRanking1.setYears("2020");
                    List<SysRanking> rankingList1 = sysRankingMapper.selectSysRankingList(sysRanking1);
                    grade = rankingList1.get(0).getGrade();
                    System.out.println("离得最近的排名："+ rankingsecond);
                }else{
                    SysRanking sysRanking1 = new SysRanking();
                    sysRanking1.setAllRanking(rankingsecond);
                    sysRanking1.setYears("2020");
                    List<SysRanking> rankingList1 = sysRankingMapper.selectSysRankingList(sysRanking1);
                    grade = rankingList1.get(0).getGrade();
                    System.out.println("离得最近的排名:"+rankingOne);
                }
            }
            System.out.println("最终同位分："+grade);
            sysStudent.setAppositive(grade);
        }
        return sysStudentMapper.updateSysStudent(sysStudent);
    }

    /**
     * 删除学生表对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysStudentByIds(String ids)
    {
        return sysStudentMapper.deleteSysStudentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生表信息
     *
     * @param stuId 学生表ID
     * @return 结果
     */
    @Override
    public int deleteSysStudentById(Long stuId)
    {
        return sysStudentMapper.deleteSysStudentById(stuId);
    }
}