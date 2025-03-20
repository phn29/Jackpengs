package com.zyx.system.service.impl;

import com.zyx.common.core.domain.entity.SysMajor;
import com.zyx.common.core.domain.entity.SysSalary;
import com.zyx.common.core.text.Convert;
import com.zyx.system.mapper.SysSalaryMapper;
import com.zyx.system.service.ISysSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 专业薪资列表Service业务层处理
 *
 * @author 张银祥
 * @date 2021-07-13
 */
@Service
public class SysSalaryServiceImpl implements ISysSalaryService
{
    @Autowired
    private SysSalaryMapper sysSalaryMapper;

    /**
     * 查询专业薪资列表
     *
     * @param salaryId 专业薪资列表ID
     * @return 专业薪资列表
     */
    @Override
    public SysSalary selectSysSalaryById(Long salaryId)
    {
        return sysSalaryMapper.selectSysSalaryById(salaryId);
    }

    /**
     * 查询专业表
     *
     * @param majorId 专业列表id
     * @return 专业列表
     */
    @Override
    public List<SysSalary> selectSysSalaryByMajorId(Long majorId) {
        return sysSalaryMapper.selectSysSalaryByMajorId(majorId);
    }

    /**
     * 查询专业薪资列表列表
     *
     * @param sysSalary 专业薪资列表
     * @return 专业薪资列表
     */
    @Override
    public List<SysSalary> selectSysSalaryList(SysSalary sysSalary)
    {
        return sysSalaryMapper.selectSysSalaryList(sysSalary);
    }

    /**
     * 新增专业薪资列表
     *
     * @param sysSalary 专业薪资列表
     * @return 结果
     */
    @Override
    public int insertSysSalary(SysSalary sysSalary)
    {
        return sysSalaryMapper.insertSysSalary(sysSalary);
    }

    /**
     * 修改专业薪资列表
     *
     * @param sysSalary 专业薪资列表
     * @return 结果
     */
    @Override
    public int updateSysSalary(SysSalary sysSalary)
    {
        return sysSalaryMapper.updateSysSalary(sysSalary);
    }

    /**
     * 删除专业薪资列表对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysSalaryByIds(String ids)
    {
        return sysSalaryMapper.deleteSysSalaryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专业薪资列表信息
     *
     * @param salaryId 专业薪资列表ID
     * @return 结果
     */
    @Override
    public int deleteSysSalaryById(Long salaryId)
    {
        return sysSalaryMapper.deleteSysSalaryById(salaryId);
    }

    /**
     * 查询平均工资
     * @return 平均工资
     */
    @Override
    public SysSalary selectAverageSalary(SysSalary sysSalary) {
        return sysSalaryMapper.selectAverageSalary(sysSalary);
    }
}
