package com.zyx.system.service.impl;

import java.util.List;
import com.zyx.common.core.domain.entity.SysHost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zyx.system.mapper.SysHostMapper;
import com.zyx.system.service.ISysHostService;
import com.zyx.common.core.text.Convert;

/**
 * 热点新闻表Service业务层处理
 * 
 * @author 张银祥
 * @date 2021-05-29
 */
@Service
public class SysHostServiceImpl implements ISysHostService 
{
    @Autowired
    private SysHostMapper sysHostMapper;

    /**
     * 查询热点新闻表
     * 
     * @param hostId 热点新闻表ID
     * @return 热点新闻表
     */
    @Override
    public SysHost selectSysHostById(Long hostId)
    {
        return sysHostMapper.selectSysHostById(hostId);
    }

    /**
     * 查询热点新闻表列表
     * 
     * @param sysHost 热点新闻表
     * @return 热点新闻表
     */
    @Override
    public List<SysHost> selectSysHostList(SysHost sysHost)
    {
        return sysHostMapper.selectSysHostList(sysHost);
    }

    /**
     * 新增热点新闻表
     * 
     * @param sysHost 热点新闻表
     * @return 结果
     */
    @Override
    public int insertSysHost(SysHost sysHost)
    {
        return sysHostMapper.insertSysHost(sysHost);
    }

    /**
     * 修改热点新闻表
     * 
     * @param sysHost 热点新闻表
     * @return 结果
     */
    @Override
    public int updateSysHost(SysHost sysHost)
    {
        return sysHostMapper.updateSysHost(sysHost);
    }

    /**
     * 删除热点新闻表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysHostByIds(String ids)
    {
        return sysHostMapper.deleteSysHostByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除热点新闻表信息
     * 
     * @param hostId 热点新闻表ID
     * @return 结果
     */
    @Override
    public int deleteSysHostById(Long hostId)
    {
        return sysHostMapper.deleteSysHostById(hostId);
    }
}
