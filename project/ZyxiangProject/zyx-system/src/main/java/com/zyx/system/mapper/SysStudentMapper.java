package com.zyx.system.mapper;

import com.zyx.common.core.domain.entity.SysStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学生表Mapper接口
 *
 * @author 张银祥
 * @date 2021-05-26
 */
public interface SysStudentMapper
{

    //核对用户名(考生考号)和考生密码
    public SysStudent findBystuNoAndstuPassword(@Param("stuNo") String stuNo, @Param("stuPassword") String stuPassword);
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
    public int updateSysStudent(SysStudent sysStudent);

    /**
     * 删除学生表
     *
     * @param stuId 学生表ID
     * @return 结果
     */
    public int deleteSysStudentById(Long stuId);

    /**
     * 批量删除学生表
     *
     * @param stuIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysStudentByIds(String[] stuIds);
}