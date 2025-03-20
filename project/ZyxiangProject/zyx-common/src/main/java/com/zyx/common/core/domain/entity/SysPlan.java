package com.zyx.common.core.domain.entity;

import com.zyx.common.annotation.Excel;
import com.zyx.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 计划招生表对象 sys_plan
 *
 * @author 张银祥
 * @date 2021-06-15
 */
public class SysPlan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 招生计划id */
    private Long planId;

    /** 院校层次 */
    @Excel(name = "院校层次")
    private String majorLevel;

    /** 招生专业 */
    @Excel(name = "招生专业")
    private String majorName;

    /** 年份 */
    @Excel(name = "年份")
    private String years;

    /** 招生院校 */
    @Excel(name = "招生院校")
    private String universityName;

    /** 学费 */
    @Excel(name = "学费")
    private String tuition;

    /** 最低分数 */
    @Excel(name = "最低分数")
    private Long minScore;

    /** 计划人数 */
    @Excel(name = "计划人数")
    private Long annualTarget;

    /** 最低位次 */
    @Excel(name = "最低位次")
    private Long minRanking;

    /** 投出数 */
    @Excel(name = "投出数")
    private String forSeveral;

    /** 批次 */
    @Excel(name = "批次")
    private String batch;

    /** 院校代码 */
    @Excel(name = "院校代码")
    private String universityId;

    /** 院校表 */
    private SysUniversity university;

    /** 专业表 */
    private SysMajor major;

    /** 省份 */
    private String provinceName;

    /** 城市 */
    private String cityName;

    /** 是否根据分数 0否 1是 */
    private Integer isGrade;

    /** 院校类型 */
    private String universityType;

    /** 专业门类 */
    private String majorCategory;



    public void setPlanId(Long planId)
    {
        this.planId = planId;
    }

    public Long getPlanId()
    {
        return planId;
    }
    public void setMajorLevel(String majorLevel)
    {
        this.majorLevel = majorLevel;
    }

    public String getMajorLevel()
    {
        return majorLevel;
    }
    public void setMajorName(String majorName)
    {
        this.majorName = majorName;
    }

    public String getMajorName()
    {
        return majorName;
    }
    public void setYears(String years)
    {
        this.years = years;
    }

    public String getYears()
    {
        return years;
    }
    public void setUniversityName(String universityName)
    {
        this.universityName = universityName;
    }

    public String getUniversityName()
    {
        return universityName;
    }
    public void setTuition(String tuition)
    {
        this.tuition = tuition;
    }

    public String getTuition()
    {
        return tuition;
    }
    public void setMinScore(Long minScore)
    {
        this.minScore = minScore;
    }

    public Long getMinScore()
    {
        return minScore;
    }
    public void setAnnualTarget(Long annualTarget)
    {
        this.annualTarget = annualTarget;
    }

    public Long getAnnualTarget()
    {
        return annualTarget;
    }
    public void setMinRanking(Long minRanking)
    {
        this.minRanking = minRanking;
    }

    public Long getMinRanking()
    {
        return minRanking;
    }
    public void setForSeveral(String forSeveral)
    {
        this.forSeveral = forSeveral;
    }

    public String getForSeveral()
    {
        return forSeveral;
    }
    public void setBatch(String batch)
    {
        this.batch = batch;
    }

    public String getBatch()
    {
        return batch;
    }
    public void setUniversityId(String universityId)
    {
        this.universityId = universityId;
    }

    public String getUniversityId()
    {
        return universityId;
    }

    public SysUniversity getUniversity() {
        return university;
    }

    public void setUniversity(SysUniversity university) {
        this.university = university;
    }

    public SysMajor getMajor() {
        return major;
    }

    public void setMajor(SysMajor major) {
        this.major = major;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getIsGrade() {
        return isGrade;
    }

    public void setIsGrade(Integer isGrade) {
        this.isGrade = isGrade;
    }

    public String getUniversityType() {
        return universityType;
    }

    public void setUniversityType(String universityType) {
        this.universityType = universityType;
    }

    public String getMajorCategory() {
        return majorCategory;
    }

    public void setMajorCategory(String majorCategory) {
        this.majorCategory = majorCategory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("planId", getPlanId())
                .append("majorLevel", getMajorLevel())
                .append("majorName", getMajorName())
                .append("years", getYears())
                .append("universityName", getUniversityName())
                .append("tuition", getTuition())
                .append("minScore", getMinScore())
                .append("annualTarget", getAnnualTarget())
                .append("minRanking", getMinRanking())
                .append("forSeveral", getForSeveral())
                .append("batch", getBatch())
                .append("universityId", getUniversityId())
                .append("university", getUniversity())
                .append("major", getMajor())
                .append("provinceName", getProvinceName())
                .append("cityName", getCityName())
                .append("isGrade", getIsGrade())
                .append("universityType", getUniversityType())
                .append("majorCategory", getMajorCategory())
                .toString();
    }
}

