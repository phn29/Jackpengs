package com.zyx.system.service.impl;

import com.zyx.common.core.domain.entity.SysCollection;
import com.zyx.common.core.text.Convert;
import com.zyx.common.utils.DateUtils;
import com.zyx.system.mapper.SysCollectionMapper;
import com.zyx.system.service.ISysCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户收藏记录Service业务层处理
 * 
 * @author zyx
 * @date 2022-03-30
 */
@Service
public class SysCollectionServiceImpl implements ISysCollectionService
{
    @Autowired
    private SysCollectionMapper sysCollectionMapper;

    /**
     * 查询用户收藏记录
     * 
     * @param id 用户收藏记录ID
     * @return 用户收藏记录
     */
    @Override
    public SysCollection selectSysCollectionById(Long id)
    {
        return sysCollectionMapper.selectSysCollectionById(id);
    }

    /**
     * 查询用户收藏记录列表
     * 
     * @param sysCollection 用户收藏记录
     * @return 用户收藏记录
     */
    @Override
    public List<SysCollection> selectSysCollectionList(SysCollection sysCollection)
    {
        return sysCollectionMapper.selectSysCollectionList(sysCollection);
    }

    /**
     * 新增用户收藏记录
     * 
     * @param sysCollection 用户收藏记录
     * @return 结果
     */
    @Override
    public int insertSysCollection(SysCollection sysCollection)
    {
        sysCollection.setCreateTime(DateUtils.getNowDate());
        return sysCollectionMapper.insertSysCollection(sysCollection);
    }

    /**
     * 修改用户收藏记录
     * 
     * @param sysCollection 用户收藏记录
     * @return 结果
     */
    @Override
    public int updateSysCollection(SysCollection sysCollection)
    {
        return sysCollectionMapper.updateSysCollection(sysCollection);
    }

    /**
     * 删除用户收藏记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysCollectionByIds(String ids)
    {
        return sysCollectionMapper.deleteSysCollectionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户收藏记录信息
     * 
     * @param id 用户收藏记录ID
     * @return 结果
     */
    @Override
    public int deleteSysCollectionById(Long id)
    {
        return sysCollectionMapper.deleteSysCollectionById(id);
    }
}