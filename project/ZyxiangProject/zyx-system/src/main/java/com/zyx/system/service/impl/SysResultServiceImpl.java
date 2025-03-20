package com.zyx.system.service.impl;

import com.zyx.common.core.domain.entity.SysResult;
import com.zyx.common.core.text.Convert;
import com.zyx.system.mapper.SysResultMapper;
import com.zyx.system.service.ISysResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 心理测试结果表Service业务层处理
 * 
 * @author zyx
 * @date 2022-04-30
 */
@Service
public class SysResultServiceImpl implements ISysResultService
{
    @Autowired
    private SysResultMapper sysResultMapper;

    /**
     * 查询心理测试结果表
     * 
     * @param resultId 心理测试结果表ID
     * @return 心理测试结果表
     */
    @Override
    public SysResult selectSysResultById(String resultId)
    {
        return sysResultMapper.selectSysResultById(resultId);
    }

    /**
     * 查询心理测试结果表列表
     * 
     * @param sysResult 心理测试结果表
     * @return 心理测试结果表
     */
    @Override
    public List<SysResult> selectSysResultList(SysResult sysResult)
    {
        return sysResultMapper.selectSysResultList(sysResult);
    }

    /**
     * 新增心理测试结果表
     * 
     * @param sysResult 心理测试结果表
     * @return 结果
     */
    @Override
    public int insertSysResult(SysResult sysResult)
    {
        return sysResultMapper.insertSysResult(sysResult);
    }

    /**
     * 修改心理测试结果表
     * 
     * @param sysResult 心理测试结果表
     * @return 结果
     */
    @Override
    public int updateSysResult(SysResult sysResult)
    {
        return sysResultMapper.updateSysResult(sysResult);
    }

    /**
     * 删除心理测试结果表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysResultByIds(String ids)
    {
        return sysResultMapper.deleteSysResultByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除心理测试结果表信息
     * 
     * @param resultId 心理测试结果表ID
     * @return 结果
     */
    @Override
    public int deleteSysResultById(String resultId)
    {
        return sysResultMapper.deleteSysResultById(resultId);
    }
}