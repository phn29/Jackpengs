package com.zyx.system.service;

import java.util.List;

import com.zyx.common.core.domain.entity.SysMajor;
import com.zyx.common.core.domain.entity.SysSalary;

/**
 * 专业薪资列表Service接口
 *
 * @author 张银祥
 * @date 2021-07-13
 */
public interface ISysSalaryService
{
    /**
     * 查询专业薪资列表
     *
     * @param salaryId 专业薪资列表ID
     * @return 专业薪资列表
     */
    public SysSalary selectSysSalaryById(Long salaryId);

    /**
     * 查询专业
     *
     * @param majorId 专业id
     * @return 专业表
     */
    public List<SysSalary> selectSysSalaryByMajorId(Long majorId);

    /**
     * 查询专业薪资列表列表
     *
     * @param sysSalary 专业薪资列表
     * @return 专业薪资列表集合
     */
    public List<SysSalary> selectSysSalaryList(SysSalary sysSalary);

    /**
     * 新增专业薪资列表
     *
     * @param sysSalary 专业薪资列表
     * @return 结果
     */
    public int insertSysSalary(SysSalary sysSalary);

    /**
     * 修改专业薪资列表
     *
     * @param sysSalary 专业薪资列表
     * @return 结果
     */
    public int updateSysSalary(SysSalary sysSalary);

    /**
     * 批量删除专业薪资列表
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysSalaryByIds(String ids);

    /**
     * 删除专业薪资列表信息
     *
     * @param salaryId 专业薪资列表ID
     * @return 结果
     */
    public int deleteSysSalaryById(Long salaryId);

    /**
     * 查询平均工资
     * @return 平均工资
     */
    public SysSalary selectAverageSalary(SysSalary sysSalary);
}
