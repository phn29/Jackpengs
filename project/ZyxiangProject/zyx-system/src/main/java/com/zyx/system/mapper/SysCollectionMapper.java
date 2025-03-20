package com.zyx.system.mapper;

import com.zyx.common.core.domain.entity.SysCollection;

import java.util.List;

/**
 * 用户收藏记录Mapper接口
 *
 * @author zyx
 * @date 2022-03-30
 */
public interface SysCollectionMapper
{
    /**
     * 查询用户收藏记录
     *
     * @param id 用户收藏记录ID
     * @return 用户收藏记录
     */
    public SysCollection selectSysCollectionById(Long id);

    /**
     * 查询用户收藏记录列表
     *
     * @param sysCollection 用户收藏记录
     * @return 用户收藏记录集合
     */
    public List<SysCollection> selectSysCollectionList(SysCollection sysCollection);

    /**
     * 新增用户收藏记录
     *
     * @param sysCollection 用户收藏记录
     * @return 结果
     */
    public int insertSysCollection(SysCollection sysCollection);

    /**
     * 修改用户收藏记录
     *
     * @param sysCollection 用户收藏记录
     * @return 结果
     */
    public int updateSysCollection(SysCollection sysCollection);

    /**
     * 删除用户收藏记录
     *
     * @param id 用户收藏记录ID
     * @return 结果
     */
    public int deleteSysCollectionById(Long id);

    /**
     * 批量删除用户收藏记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysCollectionByIds(String[] ids);
}
