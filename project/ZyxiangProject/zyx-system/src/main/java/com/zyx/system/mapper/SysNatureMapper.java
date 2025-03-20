package com.zyx.system.mapper;

import com.zyx.common.core.domain.entity.SysNature;

import java.util.List;

/**
 * MBTI职业性格测试题Mapper接口
 *
 * @author zyx
 * @date 2022-02-05
 */
public interface SysNatureMapper
{
    /**
     * 查询MBTI职业性格测试题
     *
     * @param natureId MBTI职业性格测试题ID
     * @return MBTI职业性格测试题
     */
    public SysNature selectSysNatureById(Long natureId);

    /**
     * 查询MBTI职业性格测试题列表
     *
     * @param sysNature MBTI职业性格测试题
     * @return MBTI职业性格测试题集合
     */
    public List<SysNature> selectSysNatureList(SysNature sysNature);

    /**
     * 新增MBTI职业性格测试题
     *
     * @param sysNature MBTI职业性格测试题
     * @return 结果
     */
    public int insertSysNature(SysNature sysNature);

    /**
     * 修改MBTI职业性格测试题
     *
     * @param sysNature MBTI职业性格测试题
     * @return 结果
     */
    public int updateSysNature(SysNature sysNature);

    /**
     * 删除MBTI职业性格测试题
     *
     * @param natureId MBTI职业性格测试题ID
     * @return 结果
     */
    public int deleteSysNatureById(Long natureId);

    /**
     * 批量删除MBTI职业性格测试题
     *
     * @param natureIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysNatureByIds(String[] natureIds);
}
