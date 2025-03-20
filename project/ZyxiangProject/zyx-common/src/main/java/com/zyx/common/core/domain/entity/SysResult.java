package com.zyx.common.core.domain.entity;

import com.zyx.common.annotation.Excel;
import com.zyx.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 心理测试结果表对象 sys_result
 * 
 * @author zyx
 * @date 2022-04-30
 */
public class SysResult extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 测试结果Id */
    private String resultId;

    /** 测试结果类型 */
    @Excel(name = "测试结果类型")
    private String resultType;

    /** 测试结果性格 */
    @Excel(name = "测试结果性格")
    private String resultNature;

    /** 性格描述 */
    @Excel(name = "性格描述")
    private String natureInfo;

    /** 院校类型 */
    @Excel(name = "院校类型")
    private String universityType;

    /** 专业类型 */
    @Excel(name = "专业类型")
    private String majorType;

    public void setResultId(String resultId) 
    {
        this.resultId = resultId;
    }

    public String getResultId() 
    {
        return resultId;
    }
    public void setResultType(String resultType) 
    {
        this.resultType = resultType;
    }

    public String getResultType() 
    {
        return resultType;
    }

    public String getResultNature() {
        return resultNature;
    }

    public void setResultNature(String resultNature) {
        this.resultNature = resultNature;
    }

    public void setNatureInfo(String natureInfo)
    {
        this.natureInfo = natureInfo;
    }

    public String getNatureInfo() 
    {
        return natureInfo;
    }

    public String getUniversityType() {
        return universityType;
    }

    public void setUniversityType(String universityType) {
        this.universityType = universityType;
    }

    public void setMajorType(String majorType)
    {
        this.majorType = majorType;
    }

    public String getMajorType() 
    {
        return majorType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("resultId", getResultId())
            .append("resultType", getResultType())
            .append("resultNature", getResultNature())
            .append("natureInfo", getNatureInfo())
            .append("universityType", getUniversityType())
            .append("majorType", getMajorType())
            .toString();
    }
}