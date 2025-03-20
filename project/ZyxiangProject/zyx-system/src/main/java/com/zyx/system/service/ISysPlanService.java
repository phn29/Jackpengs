package com.zyx.system.service;

import com.zyx.common.core.domain.entity.SysPlan;
import java.util.List;

/**
 * 计划招生表Service接口
 *
 * @author 张银祥
 * @date 2021-06-15
 */
public interface ISysPlanService
{
    /**
     * 查询计划招生表
     *
     * @param planId 计划招生表ID
     * @return 计划招生表
     */
    public SysPlan selectSysPlanById(Long planId);

    /**
     * 查询计划招生表
     *
     * @param universityId 学校ID
     * @return 计划招生表
     */
    public List<SysPlan> selectSysPlanByUniversityId(Long universityId);

    /**
     * 查询全部计划招生表列表
     *
     * @param sysPlan 计划招生表
     * @return 计划招生表集合
     */
    public List<SysPlan> selectSysPlanList(SysPlan sysPlan);

    /**
     * 查询可冲击计划招生表列表
     *
     * @param sysPlan 计划招生表
     * @return 计划招生表集合
     */
    public List<SysPlan> selectSysPlanListShock(SysPlan sysPlan);

    /**
     * 查询较稳妥计划招生表列表
     *
     * @param sysPlan 计划招生表
     * @return 计划招生表集合
     */
    public List<SysPlan> selectSysPlanListSafe(SysPlan sysPlan);

    /**
     * 查询可保底计划招生表列表
     *
     * @param sysPlan 计划招生表
     * @return 计划招生表集合
     */
    public List<SysPlan> selectSysPlanListGuaranteed(SysPlan sysPlan);

    /**
     * 通过院校类型查询招生计划
     *
     * @param universityTypes 院校类型
     * @return 计划招生表集合
     */
    public List<SysPlan> selectSysPlanByUniversityTypes(String[] universityTypes);

    /**
     * 通过院校所在省份和专业名称查询招生计划
     *
     * @param purposeAddress 所在省份 purposeMajor 专业名称
     * @return 计划招生表集合
     */
    public List<SysPlan> selectSysPlanByMajorNameAndProvinceName(String[] purposeAddress, String[] purposeMajor);

    /**
     * 通过专业名和院校名称查询招生计划
     *
     * @param majorArray 专业名称 universityArray 院校名称
     * @return 计划招生表集合
     */
    public List<SysPlan> selectSysPlanByMajorsAndUniversitys(String[] majorArray, String[] universityArray);

    /**
     * 新增计划招生表
     *
     * @param sysPlan 计划招生表
     * @return 结果
     */
    public int insertSysPlan(SysPlan sysPlan);

    /**
     * 修改计划招生表
     *
     * @param sysPlan 计划招生表
     * @return 结果
     */
    public int updateSysPlan(SysPlan sysPlan);

    /**
     * 批量删除计划招生表
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysPlanByIds(String ids);

    /**
     * 删除计划招生表信息
     *
     * @param planId 计划招生表ID
     * @return 结果
     */
    public int deleteSysPlanById(Long planId);

    /**
     * 导入招生计划数据
     *
     * @param planList 招生计划列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作专业
     * @return 结果
     */
    public String importPlan(List<SysPlan> planList, Boolean isUpdateSupport, String operName);
}
