package com.zyx.system.service;

import com.zyx.common.core.domain.entity.SysStudent;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * 学生表Service接口
 *
 * @author 张银祥
 * @date 2021-05-26
 */
public interface ISysStudentService
{

    //核对用户名(考生考号)和考生密码
    SysStudent checkUser(String stuNo, String stuPassword);
    /**
     * 查询学生表
     *
     * @param stuId 学生表ID
     * @return 学生表
     */
    public SysStudent selectSysStudentById(Long stuId);

    /**
     * 查询学生表列表
     *
     * @param sysStudent 学生表
     * @return 学生表集合
     */
    public List<SysStudent> selectSysStudentList(SysStudent sysStudent);

    /**
     * 新增学生表
     *
     * @param sysStudent 学生表
     * @return 结果
     */
    public int insertSysStudent(SysStudent sysStudent);

    /**
     * 修改学生表
     *
     * @param sysStudent 学生表
     * @return 结果
     */
    public int updateSysStudent(SysStudent sysStudent) throws IOException, ParseException;

    /**
     * 批量删除学生表
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysStudentByIds(String ids);

    /**
     * 删除学生表信息
     *
     * @param stuId 学生表ID
     * @return 结果
     */
    public int deleteSysStudentById(Long stuId);
}
