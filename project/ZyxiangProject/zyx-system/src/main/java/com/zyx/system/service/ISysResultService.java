package com.zyx.system.service;

import com.zyx.common.core.domain.entity.SysResult;

import java.util.List;

/**
 * 心理测试结果表Service接口
 * 
 * @author zyx
 * @date 2022-04-30
 */
public interface ISysResultService 
{
    /**
     * 查询心理测试结果表
     * 
     * @param resultId 心理测试结果表ID
     * @return 心理测试结果表
     */
    public SysResult selectSysResultById(String resultId);

    /**
     * 查询心理测试结果表列表
     * 
     * @param sysResult 心理测试结果表
     * @return 心理测试结果表集合
     */
    public List<SysResult> selectSysResultList(SysResult sysResult);

    /**
     * 新增心理测试结果表
     * 
     * @param sysResult 心理测试结果表
     * @return 结果
     */
    public int insertSysResult(SysResult sysResult);

    /**
     * 修改心理测试结果表
     * 
     * @param sysResult 心理测试结果表
     * @return 结果
     */
    public int updateSysResult(SysResult sysResult);

    /**
     * 批量删除心理测试结果表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysResultByIds(String ids);

    /**
     * 删除心理测试结果表信息
     * 
     * @param resultId 心理测试结果表ID
     * @return 结果
     */
    public int deleteSysResultById(String resultId);
}