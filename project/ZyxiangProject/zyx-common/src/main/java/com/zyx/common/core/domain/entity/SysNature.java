package com.zyx.common.core.domain.entity;

import com.zyx.common.annotation.Excel;
import com.zyx.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * MBTI职业性格测试题对象 sys_nature
 *
 * @author zyx
 * @date 2022-02-05
 */
public class SysNature extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long natureId;

    /** 问题 */
    @Excel(name = "问题")
    private String problem;

    /** 选项a */
    @Excel(name = "选项a")
    private String optionsA;

    /** 选项b */
    @Excel(name = "选项b")
    private String optionsB;

    /** 选项a对应的值 */
    @Excel(name = "选项a对应的值")
    private String valueA;

    /** 选项b对应的值 */
    @Excel(name = "选项b对应的值")
    private String valueB;

    public void setNatureId(Long natureId)
    {
        this.natureId = natureId;
    }

    public Long getNatureId()
    {
        return natureId;
    }
    public void setProblem(String problem)
    {
        this.problem = problem;
    }

    public String getProblem()
    {
        return problem;
    }
    public void setOptionsA(String optionsA)
    {
        this.optionsA = optionsA;
    }

    public String getOptionsA()
    {
        return optionsA;
    }
    public void setOptionsB(String optionsB)
    {
        this.optionsB = optionsB;
    }

    public String getOptionsB()
    {
        return optionsB;
    }
    public void setValueA(String valueA)
    {
        this.valueA = valueA;
    }

    public String getValueA()
    {
        return valueA;
    }
    public void setValueB(String valueB)
    {
        this.valueB = valueB;
    }

    public String getValueB()
    {
        return valueB;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("natureId", getNatureId())
                .append("problem", getProblem())
                .append("optionsA", getOptionsA())
                .append("optionsB", getOptionsB())
                .append("valueA", getValueA())
                .append("valueB", getValueB())
                .toString();
    }
}
