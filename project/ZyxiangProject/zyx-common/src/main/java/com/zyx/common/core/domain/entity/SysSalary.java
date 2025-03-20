package com.zyx.common.core.domain.entity;

import java.math.BigDecimal;
import com.zyx.common.annotation.Excel;
import com.zyx.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 专业薪资列表对象 sys_salary
 *
 * @author 张银祥
 * @date 2021-07-13
 */
public class SysSalary extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 薪资id */
    private Long salaryId;

    /** 专业id */
    @Excel(name = "专业id")
    private Long majorId;

    /** 年份 */
    @Excel(name = "年份")
    private String years;

    /** 薪资 */
    @Excel(name = "薪资")
    private BigDecimal salary;

    /** 平均薪资 **/
    private BigDecimal averageSalary;

    /** 专业 **/
    private SysMajor major;

    public void setSalaryId(Long salaryId)
    {
        this.salaryId = salaryId;
    }

    public Long getSalaryId()
    {
        return salaryId;
    }
    public void setMajorId(Long majorId)
    {
        this.majorId = majorId;
    }

    public Long getMajorId()
    {
        return majorId;
    }
    public void setYears(String years)
    {
        this.years = years;
    }

    public String getYears()
    {
        return years;
    }
    public void setSalary(BigDecimal salary)
    {
        this.salary = salary;
    }

    public BigDecimal getSalary()
    {
        return salary;
    }

    public BigDecimal getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(BigDecimal averageSalary) {
        this.averageSalary = averageSalary;
    }

    public SysMajor getMajor() {
        return major;
    }

    public void setMajor(SysMajor major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("salaryId", getSalaryId())
                .append("majorId", getMajorId())
                .append("years", getYears())
                .append("salary", getSalary())
                .append("averageSalary",getAverageSalary())
                .append("major", getMajor())
                .toString();
    }
}