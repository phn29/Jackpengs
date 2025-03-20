package com.zyx.system.mapper;

import java.util.List;

import com.zyx.common.core.domain.entity.SysTimeaxis;

/**
 * 高考时间轴表Mapper接口
 * 
 * @author 张银祥
 * @date 2021-05-31
 */
public interface SysTimeaxisMapper 
{
    /**
     * 查询高考时间轴表
     * 
     * @param timeAxisId 高考时间轴表ID
     * @return 高考时间轴表
     */
    public SysTimeaxis selectSysTimeaxisById(Long timeAxisId);

    /**
     * 查询高考时间轴表列表
     * 
     * @param sysTimeaxis 高考时间轴表
     * @return 高考时间轴表集合
     */
    public List<SysTimeaxis> selectSysTimeaxisList(SysTimeaxis sysTimeaxis);

    /**
     * 新增高考时间轴表
     * 
     * @param sysTimeaxis 高考时间轴表
     * @return 结果
     */
    public int insertSysTimeaxis(SysTimeaxis sysTimeaxis);

    /**
     * 修改高考时间轴表
     * 
     * @param sysTimeaxis 高考时间轴表
     * @return 结果
     */
    public int updateSysTimeaxis(SysTimeaxis sysTimeaxis);

    /**
     * 删除高考时间轴表
     * 
     * @param timeAxisId 高考时间轴表ID
     * @return 结果
     */
    public int deleteSysTimeaxisById(Long timeAxisId);

    /**
     * 批量删除高考时间轴表
     * 
     * @param timeAxisIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysTimeaxisByIds(String[] timeAxisIds);
}
