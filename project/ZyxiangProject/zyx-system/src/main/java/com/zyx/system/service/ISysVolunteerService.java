package com.zyx.system.service;

import com.zyx.common.core.domain.entity.SysVolunteer;

import java.util.List;

/**
 * 考生志愿表Service接口
 *
 * @author 张银祥
 * @date 2021-08-17
 */
public interface ISysVolunteerService
{
    /**
     * 查询考生志愿表
     *
     * @param volunteerId 考生志愿表ID
     * @return 考生志愿表
     */
    public SysVolunteer selectSysVolunteerById(Long volunteerId);

    /**
     * 查询考生志愿表列表
     *
     * @param sysVolunteer 考生志愿表
     * @return 考生志愿表集合
     */
    public List<SysVolunteer> selectSysVolunteerList(SysVolunteer sysVolunteer);

    /**
     * 校验志愿序号是否重复
     *
     * @param stuId 考生id volunteerNum 志愿序号
     * @return 考生志愿表集合
     */
    public SysVolunteer checkVolunteerNum(String stuId, String volunteerNum);

    /**
     * 新增考生志愿表
     *
     * @param sysVolunteer 考生志愿表
     * @return 结果
     */
    public int insertSysVolunteer(SysVolunteer sysVolunteer);

    /**
     * 修改考生志愿表
     *
     * @param sysVolunteer 考生志愿表
     * @return 结果
     */
    public int updateSysVolunteer(SysVolunteer sysVolunteer);

    /**
     * 批量删除考生志愿表
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysVolunteerByIds(String ids);

    /**
     * 删除考生志愿表信息
     *
     * @param volunteerId 考生志愿表ID
     * @return 结果
     */
    public int deleteSysVolunteerById(Long volunteerId);
}