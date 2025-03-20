package com.zyx.system.service;

import com.zyx.common.core.domain.entity.SysExpert;

import java.util.List;

/**
 * 专家表Service接口
 *
 * @author zyx
 * @date 2022-02-08
 */
public interface ISysExpertService
{
    //登录，校验用户名和密码
    public SysExpert checkUser(String expertUser, String expertPassword);

    /**
     * 查询专家表
     *
     * @param expertId 专家表ID
     * @return 专家表
     */
    public SysExpert selectSysExpertById(Long expertId);

    /**
     * 查询专家表列表
     *
     * @param sysExpert 专家表
     * @return 专家表集合
     */
    public List<SysExpert> selectSysExpertList(SysExpert sysExpert);

    /**
     * 新增专家表
     *
     * @param sysExpert 专家表
     * @return 结果
     */
    public int insertSysExpert(SysExpert sysExpert);

    /**
     * 修改专家表
     *
     * @param sysExpert 专家表
     * @return 结果
     */
    public int updateSysExpert(SysExpert sysExpert);

    /**
     * 批量删除专家表
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysExpertByIds(String ids);

    /**
     * 删除专家表信息
     *
     * @param expertId 专家表ID
     * @return 结果
     */
    public int deleteSysExpertById(Long expertId);
}