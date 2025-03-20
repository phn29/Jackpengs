package com.zyx.system.service;
import com.zyx.common.core.domain.entity.SysHistory;

import java.util.List;

/**
 * 用户历史行为Service接口
 *
 * @author 张银祥
 * @date 2022-01-16
 */
public interface ISysHistoryService
{
    /**
     * 查询用户历史行为
     *
     * @param historyId 用户历史行为ID
     * @return 用户历史行为
     */
    public SysHistory selectSysHistoryById(Long historyId);

    /**
     * 查询用户历史行为列表
     *
     * @param sysHistory 用户历史行为
     * @return 用户历史行为集合
     */
    public List<SysHistory> selectSysHistoryList(SysHistory sysHistory);

    /**
     * 查询用户搜索专业
     *
     * @param userId 用户历史行为
     * @return 用户历史行为集合
     */
    public List<SysHistory> selectSysHistoryMajor(String userId);

    /**
     * 查询用户搜索学校
     *
     * @param userId 用户历史行为
     * @return 用户历史行为集合
     */
    public List<SysHistory> selectSysHistoryUniversity(String userId);


    /**
     * 新增用户历史行为
     *
     * @param sysHistory 用户历史行为
     * @return 结果
     */
    public int insertSysHistory(SysHistory sysHistory);

    /**
     * 修改用户历史行为
     *
     * @param sysHistory 用户历史行为
     * @return 结果
     */
    public int updateSysHistory(SysHistory sysHistory);

    /**
     * 批量删除用户历史行为
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysHistoryByIds(String ids);

    /**
     * 删除用户历史行为信息
     *
     * @param historyId 用户历史行为ID
     * @return 结果
     */
    public int deleteSysHistoryById(Long historyId);


}
