package com.zyx.system.mapper;

import com.zyx.common.core.domain.entity.SysChat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 聊天记录Mapper接口
 *
 * @author zyx
 * @date 2022-02-03
 */
public interface SysChatMapper
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
     * 删除聊天记录
     *
     * @param chatId 聊天记录ID
     * @return 结果
     */
    public int deleteSysChatById(Long chatId);

    /**
     * 批量删除聊天记录
     *
     * @param chatIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysChatByIds(String[] chatIds);

    /**
     * 查找我的咨询师, 查找我的学生
     *
     * @param stuId 学生ID, consultantId 咨询师ID
     * @return 结果
     */
    public List<SysChat> selectMyself(@Param("stuId") String stuId, @Param("expertId") String expertId);

    /**
     * 删除学生
     *
     * @param stuId 聊天记录ID
     * @return 结果
     */
    public int deleteSysChatByStuId(String stuId);

    /**
     * 删除专家
     *
     * @param expertId 聊天记录ID
     * @return 结果
     */
    public int deleteSysChatByExpertId(String expertId);
}