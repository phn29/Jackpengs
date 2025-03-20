package com.zyx.system.mapper;

import com.zyx.common.core.domain.entity.SysSalary;

import java.util.List;

/**
 * 专业薪资列表Mapper接口
 *
 * @author 张银祥
 * @date 2021-07-13
 */
public interface SysSalaryMapper
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
     * 删除专业薪资列表
     *
     * @param salaryId 专业薪资列表ID
     * @return 结果
     */
    public int deleteSysSalaryById(Long salaryId);

    /**
     * 批量删除专业薪资列表
     *
     * @param salaryIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysSalaryByIds(String[] salaryIds);

    /**
     * 查询平均工资
     * @return 平均工资
     */
    public SysSalary selectAverageSalary(SysSalary sysSalary);
}