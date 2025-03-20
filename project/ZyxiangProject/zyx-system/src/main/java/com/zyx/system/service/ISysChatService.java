package com.zyx.system.service;

import java.util.List;

import com.zyx.common.core.domain.entity.SysChat;

/**
 * 聊天记录Service接口
 *
 * @author zyx
 * @date 2022-02-03
 */
public interface ISysChatService
{
    /**
     * 查询聊天记录
     *
     * @param chatId 聊天记录ID
     * @return 聊天记录
     */
    public SysChat selectSysChatById(Long chatId);

    /**
     * 查询聊天记录列表
     *
     * @param sysChat 聊天记录
     * @return 聊天记录集合
     */
    public List<SysChat> selectSysChatList(SysChat sysChat);

    /**
     * 新增聊天记录
     *
     * @param sysChat 聊天记录
     * @return 结果
     */
    public int insertSysChat(SysChat sysChat);

    /**
     * 修改聊天记录
     *
     * @param sysChat 聊天记录
     * @return 结果
     */
    public int updateSysChat(SysChat sysChat);

    /**
     * 批量删除聊天记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysChatByIds(String ids);

    /**
     * 删除聊天记录信息
     *
     * @param chatId 聊天记录ID
     * @return 结果
     */
    public int deleteSysChatById(Long chatId);

    /**
     * 查找我的咨询师, 查找我的学生
     *
     * @param stuId 学生ID, consultantId 咨询师ID
     * @return 结果
     */
    public List<SysChat> selectMyself(String stuId, String expertId);
}