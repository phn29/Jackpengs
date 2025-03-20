package com.zyx.system.mapper;

import com.zyx.common.core.domain.entity.SysExpert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 专家表Mapper接口
 *
 * @author zyx
 * @date 2022-02-08
 */
public interface SysExpertMapper
{
    //专家登录，校验用户名和密码
    public SysExpert checkUser(@Param("expertUser") String expertUser, @Param("expertPassword") String expertPassword);
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
     * 删除专家表
     *
     * @param expertId 专家表ID
     * @return 结果
     */
    public int deleteSysExpertById(Long expertId);

    /**
     * 批量删除专家表
     *
     * @param expertIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysExpertByIds(String[] expertIds);
}