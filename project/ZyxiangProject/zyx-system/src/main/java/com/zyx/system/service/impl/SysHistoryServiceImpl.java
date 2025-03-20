package com.zyx.system.service.impl;
import com.zyx.common.core.domain.entity.SysHistory;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zyx.system.mapper.SysHistoryMapper;
import com.zyx.system.service.ISysHistoryService;
import com.zyx.common.core.text.Convert;

/**
 * 用户历史行为Service业务层处理
 *
 * @author 张银祥
 * @date 2022-01-16
 */
@Service
public class SysHistoryServiceImpl implements ISysHistoryService {
    @Autowired
    private SysHistoryMapper sysHistoryMapper;

    /**
     * 查询用户历史行为
     *
     * @param historyId 用户历史行为ID
     * @return 用户历史行为
     */
    @Override
    public SysHistory selectSysHistoryById(Long historyId) {
        return sysHistoryMapper.selectSysHistoryById(historyId);
    }

    /**
     * 查询用户历史行为列表
     *
     * @param sysHistory 用户历史行为
     * @return 用户历史行为
     */
    @Override
    public List<SysHistory> selectSysHistoryList(SysHistory sysHistory) {
        return sysHistoryMapper.selectSysHistoryList(sysHistory);
    }

    @Override
    public List<SysHistory> selectSysHistoryMajor(String userId) {
        return sysHistoryMapper.selectSysHistoryMajor(userId);
    }

    @Override
    public List<SysHistory> selectSysHistoryUniversity(String userId) {
        return sysHistoryMapper.selectSysHistoryUniversity(userId);
    }

    /**
     * 新增用户历史行为
     *
     * @param sysHistory 用户历史行为
     * @return 结果
     */
    @Override
    //如果没有此用户的历史行为数据则添加，有数据则进行修改次数加一
    public int insertSysHistory(SysHistory sysHistory) {
        //通过用户查询用户历史行为时候有数据，无则添加有则修改
        List list = selectSysHistoryList(sysHistory);
        System.out.println(list);
        if(list.size() == 0){
            sysHistory.setHistoryNumber(1L);
            sysHistory.setCreateTime(new Date());
            return sysHistoryMapper.insertSysHistory(sysHistory);
        }else{
           SysHistory sysHistory1 = (SysHistory) list.get(0);
           Long historyNumber = sysHistory1.getHistoryNumber();
           ++historyNumber;
           sysHistory.setHistoryNumber(historyNumber);
           sysHistory.setCreateTime(new Date());
           return sysHistoryMapper.updateSysHistory(sysHistory);
        }
    }

    /**
     * 修改用户历史行为
     *
     * @param sysHistory 用户历史行为
     * @return 结果
     */
    @Override
    public int updateSysHistory(SysHistory sysHistory) {
        return sysHistoryMapper.updateSysHistory(sysHistory);
    }

    /**
     * 删除用户历史行为对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysHistoryByIds(String ids) {
        return sysHistoryMapper.deleteSysHistoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户历史行为信息
     *
     * @param historyId 用户历史行为ID
     * @return 结果
     */
    @Override
    public int deleteSysHistoryById(Long historyId) {
        return sysHistoryMapper.deleteSysHistoryById(historyId);
    }
}