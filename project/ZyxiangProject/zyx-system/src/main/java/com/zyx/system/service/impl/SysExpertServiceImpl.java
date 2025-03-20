package com.zyx.system.service.impl;

import com.zyx.common.core.domain.entity.SysExpert;
import com.zyx.common.core.text.Convert;
import com.zyx.system.mapper.SysExpertMapper;
import com.zyx.system.service.ISysExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 专家表Service业务层处理
 *
 * @author zyx
 * @date 2022-02-08
 */
@Service
public class SysExpertServiceImpl implements ISysExpertService
{
    @Autowired
    private SysExpertMapper sysExpertMapper;

    @Override
    public SysExpert checkUser(String expertUser, String expertPassword) {
        return sysExpertMapper.checkUser(expertUser, expertPassword);
    }

    /**
     * 查询专家表
     *
     * @param expertId 专家表ID
     * @return 专家表
     */
    @Override
    public SysExpert selectSysExpertById(Long expertId)
    {
        return sysExpertMapper.selectSysExpertById(expertId);
    }

    /**
     * 查询专家表列表
     *
     * @param sysExpert 专家表
     * @return 专家表
     */
    @Override
    public List<SysExpert> selectSysExpertList(SysExpert sysExpert)
    {
        return sysExpertMapper.selectSysExpertList(sysExpert);
    }

    /**
     * 新增专家表
     *
     * @param sysExpert 专家表
     * @return 结果
     */
    @Override
    public int insertSysExpert(SysExpert sysExpert)
    {
        return sysExpertMapper.insertSysExpert(sysExpert);
    }

    /**
     * 修改专家表
     *
     * @param sysExpert 专家表
     * @return 结果
     */
    @Override
    public int updateSysExpert(SysExpert sysExpert)
    {
        return sysExpertMapper.updateSysExpert(sysExpert);
    }

    /**
     * 删除专家表对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysExpertByIds(String ids)
    {
        return sysExpertMapper.deleteSysExpertByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专家表信息
     *
     * @param expertId 专家表ID
     * @return 结果
     */
    @Override
    public int deleteSysExpertById(Long expertId)
    {
        return sysExpertMapper.deleteSysExpertById(expertId);
    }
}
