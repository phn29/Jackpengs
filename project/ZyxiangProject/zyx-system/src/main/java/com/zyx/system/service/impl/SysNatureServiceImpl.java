package com.zyx.system.service.impl;

import java.util.List;

import com.zyx.common.core.domain.entity.SysNature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zyx.system.mapper.SysNatureMapper;
import com.zyx.system.service.ISysNatureService;
import com.zyx.common.core.text.Convert;

/**
 * MBTI职业性格测试题Service业务层处理
 *
 * @author zyx
 * @date 2022-02-05
 */
@Service
public class SysNatureServiceImpl implements ISysNatureService
{
    @Autowired
    private SysNatureMapper sysNatureMapper;

    /**
     * 查询MBTI职业性格测试题
     *
     * @param natureId MBTI职业性格测试题ID
     * @return MBTI职业性格测试题
     */
    @Override
    public SysNature selectSysNatureById(Long natureId)
    {
        return sysNatureMapper.selectSysNatureById(natureId);
    }

    /**
     * 查询MBTI职业性格测试题列表
     *
     * @param sysNature MBTI职业性格测试题
     * @return MBTI职业性格测试题
     */
    @Override
    public List<SysNature> selectSysNatureList(SysNature sysNature)
    {
        return sysNatureMapper.selectSysNatureList(sysNature);
    }

    /**
     * 新增MBTI职业性格测试题
     *
     * @param sysNature MBTI职业性格测试题
     * @return 结果
     */
    @Override
    public int insertSysNature(SysNature sysNature)
    {
        return sysNatureMapper.insertSysNature(sysNature);
    }

    /**
     * 修改MBTI职业性格测试题
     *
     * @param sysNature MBTI职业性格测试题
     * @return 结果
     */
    @Override
    public int updateSysNature(SysNature sysNature)
    {
        return sysNatureMapper.updateSysNature(sysNature);
    }

    /**
     * 删除MBTI职业性格测试题对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysNatureByIds(String ids)
    {
        return sysNatureMapper.deleteSysNatureByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除MBTI职业性格测试题信息
     *
     * @param natureId MBTI职业性格测试题ID
     * @return 结果
     */
    @Override
    public int deleteSysNatureById(Long natureId)
    {
        return sysNatureMapper.deleteSysNatureById(natureId);
    }
}
