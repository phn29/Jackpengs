package com.zyx.system.service.impl;

import java.util.List;
import com.zyx.common.core.domain.entity.SysVolunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zyx.system.mapper.SysVolunteerMapper;
import com.zyx.system.service.ISysVolunteerService;
import com.zyx.common.core.text.Convert;

/**
 * 考生志愿表Service业务层处理
 *
 * @author 张银祥
 * @date 2021-08-17
 */
@Service
public class SysVolunteerServiceImpl implements ISysVolunteerService
{
    @Autowired
    private SysVolunteerMapper sysVolunteerMapper;

    /**
     * 查询考生志愿表
     *
     * @param volunteerId 考生志愿表ID
     * @return 考生志愿表
     */
    @Override
    public SysVolunteer selectSysVolunteerById(Long volunteerId)
    {
        return sysVolunteerMapper.selectSysVolunteerById(volunteerId);
    }

    /**
     * 查询考生志愿表列表
     *
     * @param sysVolunteer 考生志愿表
     * @return 考生志愿表
     */
    @Override
    public List<SysVolunteer> selectSysVolunteerList(SysVolunteer sysVolunteer)
    {
        return sysVolunteerMapper.selectSysVolunteerList(sysVolunteer);
    }

    /**
     * 校验志愿序号是否重复
     *
     * @param stuId 考生id volunteerNum 志愿序号
     * @return 考生志愿表集合
     */
    public SysVolunteer checkVolunteerNum(String stuId, String volunteerNum){
        return sysVolunteerMapper.checkVolunteerNum(stuId, volunteerNum);
    }

    /**
     * 新增考生志愿表
     *
     * @param sysVolunteer 考生志愿表
     * @return 结果
     */
    @Override
    public int insertSysVolunteer(SysVolunteer sysVolunteer)
    {
        return sysVolunteerMapper.insertSysVolunteer(sysVolunteer);
    }

    /**
     * 修改考生志愿表
     *
     * @param sysVolunteer 考生志愿表
     * @return 结果
     */
    @Override
    public int updateSysVolunteer(SysVolunteer sysVolunteer)
    {
        return sysVolunteerMapper.updateSysVolunteer(sysVolunteer);
    }

    /**
     * 删除考生志愿表对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysVolunteerByIds(String ids)
    {
        return sysVolunteerMapper.deleteSysVolunteerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考生志愿表信息
     *
     * @param volunteerId 考生志愿表ID
     * @return 结果
     */
    @Override
    public int deleteSysVolunteerById(Long volunteerId)
    {
        return sysVolunteerMapper.deleteSysVolunteerById(volunteerId);
    }
}