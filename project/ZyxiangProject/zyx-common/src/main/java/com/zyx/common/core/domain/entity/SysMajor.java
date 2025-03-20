package com.zyx.common.core.domain.entity;

import com.zyx.common.annotation.Excel;
import com.zyx.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 专业表对象 sys_major
 *
 * @author 张银祥
 * @date 2021-05-26
 */
public class SysMajor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专业id */
    private Long majorId;

    /** 专业代码 */
    @Excel(name = "专业代码")
    private String majorCode;

    /** 专业门类 */
    @Excel(name = "学科门类")
    private String majorCategory;

    /** 专业类 */
    @Excel(name = "专业类")
    private String majorType;

    /** 修业年限 */
    @Excel(name = "修业年限")
    private String studyYears;

    /** 授予学士 */
    @Excel(name = "授予学位")
    private String grantScholar;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String majorName;

    /** 专业层次 */
    @Excel(name = "专业层次")
    private String majorLevel;

    /** 专业介绍 */
    @Excel(name = "专业介绍")
    private String majorIntroduce;

    /** 性别比例 */
    @Excel(name = "性别比例")
    private String sexRatio;

    /** 选考（学科）建议 */
    @Excel(name = "选考（学科）建议")
    private String subjectProposal;

    /** 专业学什么 */
    @Excel(name = "专业学什么")
    private String majorStudy;

    /** 专业干什么 */
    @Excel(name = "专业干什么")
    private String majorWhat;

    /** 第一印象 */
    @Excel(name = "第一印象")
    private String firstImpression;

    /** 就业率 */
    @Excel(name = "就业率")
    private String employmentRate;



    public void setMajorId(Long majorId)
    {
        this.majorId = majorId;
    }

    public Long getMajorId()
    {
        return majorId;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public String getMajorCategory() {
        return majorCategory;
    }

    public void setMajorCategory(String majorCategory) {
        this.majorCategory = majorCategory;
    }

    public String getMajorType() {
        return majorType;
    }

    public void setMajorType(String majorType) {
        this.majorType = majorType;
    }

    public String getStudyYears() {
        return studyYears;
    }

    public void setStudyYears(String studyYears) {
        this.studyYears = studyYears;
    }

    public String getGrantScholar() {
        return grantScholar;
    }

    public void setGrantScholar(String grantScholar) {
        this.grantScholar = grantScholar;
    }

    public void setMajorName(String majorName)
    {
        this.majorName = majorName;
    }

    public String getMajorName()
    {
        return majorName;
    }

    public String getMajorLevel() {
        return majorLevel;
    }

    public void setMajorLevel(String majorLevel) {
        this.majorLevel = majorLevel;
    }

    public void setMajorIntroduce(String majorIntroduce)
    {
        this.majorIntroduce = majorIntroduce;
    }

    public String getFirstImpression() {
        return firstImpression;
    }

    public void setFirstImpression(String firstImpression) {
        this.firstImpression = firstImpression;
    }

    public String getEmploymentRate() {
        return employmentRate;
    }

    public void setEmploymentRate(String employmentRate) {
        this.employmentRate = employmentRate;
    }

    public String getMajorIntroduce(){
        return majorIntroduce;
    }

    public String getSexRatio() {
        return sexRatio;
    }

    public void setSexRatio(String sexRatio) {
        this.sexRatio = sexRatio;
    }

    public String getSubjectProposal() {
        return subjectProposal;
    }

    public void setSubjectProposal(String subjectProposal) {
        this.subjectProposal = subjectProposal;
    }

    public String getMajorStudy() {
        return majorStudy;
    }

    public void setMajorStudy(String majorStudy) {
        this.majorStudy = majorStudy;
    }

    public String getMajorWhat() {
        return majorWhat;
    }

    public void setMajorWhat(String majorWhat) {
        this.majorWhat = majorWhat;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("majorId", getMajorId())
                .append("majorCode", getMajorCode())
                .append("majorCategory", getMajorCategory())
                .append("majorType", getMajorType())
                .append("studyYears", getStudyYears())
                .append("grantScholar", getGrantScholar())
                .append("majorName", getMajorName())
                .append("majorLevel", getMajorLevel())
                .append("majorIntroduce", getMajorIntroduce())
                .append("sexRatio", getSexRatio())
                .append("subjectProposal", getSubjectProposal())
                .append("majorStudy", getMajorStudy())
                .append("majorWhat", getMajorWhat())
                .append("firstImpression", getFirstImpression())
                .append("employmentRate", getEmploymentRate())
                .toString();
    }
}
