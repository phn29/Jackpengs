package com.zyx.system.mapper;

import com.zyx.common.core.domain.entity.SysRanking;
import java.util.List;

/**
 * 一分一段表（位次表）Mapper接口
 *
 * @author 张银祥
 * @date 2021-08-10
 */
public interface SysRankingMapper
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
     * 删除一分一段表（位次表）
     *
     * @param rankingId 一分一段表（位次表）ID
     * @return 结果
     */
    public int deleteSysRankingById(Long rankingId);

    /**
     * 批量删除一分一段表（位次表）
     *
     * @param rankingIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysRankingByIds(String[] rankingIds);
}
