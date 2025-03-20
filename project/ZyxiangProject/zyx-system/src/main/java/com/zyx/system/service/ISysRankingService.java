package com.zyx.system.service;

import com.zyx.common.core.domain.entity.SysRanking;
import com.zyx.common.core.domain.entity.SysVolunteer;

import java.util.List;

/**
 * 一分一段表（位次表）Service接口
 *
 * @author 张银祥
 * @date 2021-08-10
 */
public interface ISysRankingService
{
    /**
     * 查询一分一段表（位次表）
     *
     * @param rankingId 一分一段表（位次表）ID
     * @return 一分一段表（位次表）
     */
    public SysRanking selectSysRankingById(Long rankingId);

    /**
     * 查询一分一段表（位次表）列表
     *
     * @param sysRanking 一分一段表（位次表）
     * @return 一分一段表（位次表）集合
     */
    public List<SysRanking> selectSysRankingList(SysRanking sysRanking);


    /**
     * 根据排名获取分数
     *
     * @param sysRanking 一分一段表（位次表）
     * @return SysRanking
     */
    public List<SysRanking> selectSysRankingByGrade(SysRanking sysRanking);

    /**
     * 新增一分一段表（位次表）
     *
     * @param sysRanking 一分一段表（位次表）
     * @return 结果
     */
    public int insertSysRanking(SysRanking sysRanking);

    /**
     * 修改一分一段表（位次表）
     *
     * @param sysRanking 一分一段表（位次表）
     * @return 结果
     */
    public int updateSysRanking(SysRanking sysRanking);

    /**
     * 批量删除一分一段表（位次表）
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysRankingByIds(String ids);

    /**
     * 删除一分一段表（位次表）信息
     *
     * @param rankingId 一分一段表（位次表）ID
     * @return 结果
     */
    public int deleteSysRankingById(Long rankingId);

    /**
     * 导入一分一段表（位次表）信息
     *
     * @param rankingList 一分一段表（位次表）列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作专业
     * @return 结果
     */
    public String importRanking(List<SysRanking> rankingList, Boolean isUpdateSupport, String operName);
}
