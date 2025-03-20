package com.zyx.system.service.impl;

import java.util.List;
import com.zyx.common.core.domain.entity.SysTimeaxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zyx.system.mapper.SysTimeaxisMapper;
import com.zyx.system.service.ISysTimeaxisService;
import com.zyx.common.core.text.Convert;

/**
 * 高考时间轴表Service业务层处理
 * 
 * @author 张银祥
 * @date 2021-05-31
 */
@Service
public class SysTimeaxisServiceImpl implements ISysTimeaxisService 
{
    @Autowired
    private SysTimeaxisMapper sysTimeaxisMapper;

    /**
     * 查询高考时间轴表
     * 
     * @param timeAxisId 高考时间轴表ID
     * @return 高考时间轴表
     */
    @Override
    public SysTimeaxis selectSysTimeaxisById(Long timeAxisId)
    {
        return sysTimeaxisMapper.selectSysTimeaxisById(timeAxisId);
    }

    /**
     * 查询高考时间轴表列表
     * 
     * @param sysTimeaxis 高考时间轴表
     * @return 高考时间轴表
     */
    @Override
    public List<SysTimeaxis> selectSysTimeaxisList(SysTimeaxis sysTimeaxis)
    {
        return sysTimeaxisMapper.selectSysTimeaxisList(sysTimeaxis);
    }

    /**
     * 新增高考时间轴表
     * 
     * @param sysTimeaxis 高考时间轴表
     * @return 结果
     */
    @Override
    public int insertSysTimeaxis(SysTimeaxis sysTimeaxis)
    {
        return sysTimeaxisMapper.insertSysTimeaxis(sysTimeaxis);
    }

    /**
     * 修改高考时间轴表
     * 
     * @param sysTimeaxis 高考时间轴表
     * @return 结果
     */
    @Override
    public int updateSysTimeaxis(SysTimeaxis sysTimeaxis)
    {
        return sysTimeaxisMapper.updateSysTimeaxis(sysTimeaxis);
    }

    /**
     * 删除高考时间轴表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysTimeaxisByIds(String ids)
    {
        return sysTimeaxisMapper.deleteSysTimeaxisByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除高考时间轴表信息
     * 
     * @param timeAxisId 高考时间轴表ID
     * @return 结果
     */
    @Override
    public int deleteSysTimeaxisById(Long timeAxisId)
    {
        return sysTimeaxisMapper.deleteSysTimeaxisById(timeAxisId);
    }
}
