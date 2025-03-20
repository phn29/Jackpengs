package com.zyx.system.service.impl;

import java.util.List;

import com.zyx.common.core.domain.entity.SysChat;
import com.zyx.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zyx.system.mapper.SysChatMapper;
import com.zyx.system.service.ISysChatService;
import com.zyx.common.core.text.Convert;

/**
 * 聊天记录Service业务层处理
 *
 * @author zyx
 * @date 2022-02-03
 */
@Service
public class SysChatServiceImpl implements ISysChatService
{
    @Autowired
    private SysChatMapper sysChatMapper;

    /**
     * 查询聊天记录
     *
     * @param chatId 聊天记录ID
     * @return 聊天记录
     */
    @Override
    public SysChat selectSysChatById(Long chatId)
    {
        return sysChatMapper.selectSysChatById(chatId);
    }

    /**
     * 查询聊天记录列表
     *
     * @param sysChat 聊天记录
     * @return 聊天记录
     */
    @Override
    public List<SysChat> selectSysChatList(SysChat sysChat)
    {
        return sysChatMapper.selectSysChatList(sysChat);
    }

    /**
     * 新增聊天记录
     *
     * @param sysChat 聊天记录
     * @return 结果
     */
    @Override
    public int insertSysChat(SysChat sysChat)
    {
        sysChat.setCreateTime(DateUtils.getNowDate());
        return sysChatMapper.insertSysChat(sysChat);
    }

    /**
     * 修改聊天记录
     *
     * @param sysChat 聊天记录
     * @return 结果
     */
    @Override
    public int updateSysChat(SysChat sysChat)
    {
        return sysChatMapper.updateSysChat(sysChat);
    }

    /**
     * 删除聊天记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysChatByIds(String ids)
    {
        return sysChatMapper.deleteSysChatByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除聊天记录信息
     *
     * @param chatId 聊天记录ID
     * @return 结果
     */
    @Override
    public int deleteSysChatById(Long chatId)
    {
        return sysChatMapper.deleteSysChatById(chatId);
    }

    @Override
    public List<SysChat> selectMyself(String stuId, String expertId) {
        return sysChatMapper.selectMyself(stuId, expertId);
    }
}