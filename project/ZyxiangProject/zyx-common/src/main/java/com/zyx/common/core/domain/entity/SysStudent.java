package com.zyx.common.core.domain.entity;

import com.zyx.common.annotation.Excel;
import com.zyx.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 考生表对象 sys_student
 *
 * @author 张银祥
 * @date 2021-05-26
 */
public class SysStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学生id主键 */
    private Long stuId;

    /** 登录账号 */
    @Excel(name = "登录账号")
    private String stuNo;

    /** 考生密码 */
    @Excel(name = "考生密码")
    private String stuPassword;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String stuName;

    /** 学生性别（0男 1女 2未知） */
    @Excel(name = "学生性别", readConverterExp = "0=男,1=女,2=未知")
    private String stuSex;

    /** 学生家庭地址 */
    @Excel(name = "学生家庭地址")
    private String stuAddress;

    /** 考生年龄 */
    @Excel(name = "考生年龄")
    private Long stuAge;

    /** 考生成绩 */
    @Excel(name = "考生成绩")
    private Long stuScore;

    /** 考生邮箱 */
    @Excel(name = "考生邮箱")
    private String stuEmail;

    /** 考生电话 */
    @Excel(name = "考生电话")
    private String stuPhone;

    /** 考生邮编 */
    @Excel(name = "考生邮编")
    private String stuPostcode;

    /** 意向省份 */
    @Excel(name = "意向省份")
    private String provinceName;

    /** 意向城市 */
    @Excel(name = "意向城市")
    private String cityName;

    /** 排名 */
    @Excel(name = "排名")
    private String ranking;

    /** 物理（0不选 1选） */
    @Excel(name = "物理", readConverterExp = "0=不选,1=选")
    private String physics;

    /** 化学（0不选 1选） */
    @Excel(name = "化学", readConverterExp = "0=不选,1=选")
    private String chemistry;

    /** 生物（0不选 1选） */
    @Excel(name = "生物", readConverterExp = "0=不选,1=选")
    private String biology;

    /** 政治（0不选 1选） */
    @Excel(name = "政治", readConverterExp = "0=不选,1=选")
    private String politics;

    /** 历史（0不选 1选） */
    @Excel(name = "历史", readConverterExp = "0=不选,1=选")
    private String history;

    /** 地理（0不选 1选） */
    @Excel(name = "地理", readConverterExp = "0=不选,1=选")
    private String geography;

    /** 最终选科 */
    @Excel(name = "最终选科")
    private String optional;

    /** MBTI测试结果 */
    @Excel(name = "MBTI测试结果")
    private String mbtiResult;

    /** 意向地区一 */
    @Excel(name = "意向地区一")
    private String purposeAddressOne;

    /** 意向地区一 */
    @Excel(name = "意向地区二")
    private String purposeAddressTwo;

    /** 意向地区一 */
    @Excel(name = "意向地区三")
    private String purposeAddressThree;

    /** 意向专业一 */
    @Excel(name = "意向专业一")
    private String purposeMajorOne;

    /** 意向专业二 */
    @Excel(name = "意向专业二")
    private String purposeMajorTwo;

    /** 意向专业三*/
    @Excel(name = "意向专业三")
    private String purposeMajorThree;

    /** 同位分*/
    @Excel(name = "同位分")
    private Long appositive;

    public void setStuId(Long stuId)
    {
        this.stuId = stuId;
    }

    public Long getStuId()
    {
        return stuId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public void setStuPassword(String stuPassword)
    {
        this.stuPassword = stuPassword;
    }

    public String getStuPassword()
    {
        return stuPassword;
    }
    public void setStuName(String stuName)
    {
        this.stuName = stuName;
    }

    public String getStuName()
    {
        return stuName;
    }
    public void setStuSex(String stuSex)
    {
        this.stuSex = stuSex;
    }

    public String getStuSex()
    {
        return stuSex;
    }
    public void setStuAddress(String stuAddress)
    {
        this.stuAddress = stuAddress;
    }

    public String getStuAddress()
    {
        return stuAddress;
    }
    public void setStuAge(Long stuAge)
    {
        this.stuAge = stuAge;
    }

    public Long getStuAge()
    {
        return stuAge;
    }
    public void setStuScore(Long stuScore)
    {
        this.stuScore = stuScore;
    }

    public Long getStuScore()
    {
        return stuScore;
    }
    public void setStuEmail(String stuEmail)
    {
        this.stuEmail = stuEmail;
    }

    public String getStuEmail()
    {
        return stuEmail;
    }
    public void setStuPhone(String stuPhone)
    {
        this.stuPhone = stuPhone;
    }

    public String getStuPhone()
    {
        return stuPhone;
    }
    public void setStuPostcode(String stuPostcode)
    {
        this.stuPostcode = stuPostcode;
    }

    public String getStuPostcode()
    {
        return stuPostcode;
    }
    public void setProvinceName(String provinceName)
    {
        this.provinceName = provinceName;
    }

    public String getProvinceName()
    {
        return provinceName;
    }
    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public String getCityName()
    {
        return cityName;
    }
    public void setRanking(String ranking)
    {
        this.ranking = ranking;
    }

    public String getRanking()
    {
        return ranking;
    }
    public void setPhysics(String physics)
    {
        this.physics = physics;
    }

    public String getPhysics()
    {
        return physics;
    }
    public void setChemistry(String chemistry)
    {
        this.chemistry = chemistry;
    }

    public String getChemistry()
    {
        return chemistry;
    }

    public String getBiology() {
        return biology;
    }

    public void setBiology(String biology) {
        this.biology = biology;
    }

    public void setPolitics(String politics)
    {
        this.politics = politics;
    }

    public String getPolitics()
    {
        return politics;
    }
    public void setHistory(String history)
    {
        this.history = history;
    }

    public String getHistory()
    {
        return history;
    }
    public void setGeography(String geography)
    {
        this.geography = geography;
    }

    public String getGeography()
    {
        return geography;
    }

    public String getOptional() {
        return optional;
    }

    public void setOptional(String optional) {
        this.optional = optional;
    }

    public String getMbtiResult() {
        return mbtiResult;
    }

    public void setMbtiResult(String mbtiResult) {
        this.mbtiResult = mbtiResult;
    }

    public String getPurposeAddressOne() {
        return purposeAddressOne;
    }

    public void setPurposeAddressOne(String purposeAddressOne) {
        this.purposeAddressOne = purposeAddressOne;
    }

    public String getPurposeAddressTwo() {
        return purposeAddressTwo;
    }

    public void setPurposeAddressTwo(String purposeAddressTwo) {
        this.purposeAddressTwo = purposeAddressTwo;
    }

    public String getPurposeAddressThree() {
        return purposeAddressThree;
    }

    public void setPurposeAddressThree(String purposeAddressThree) {
        this.purposeAddressThree = purposeAddressThree;
    }

    public String getPurposeMajorOne() {
        return purposeMajorOne;
    }

    public void setPurposeMajorOne(String purposeMajorOne) {
        this.purposeMajorOne = purposeMajorOne;
    }

    public String getPurposeMajorTwo() {
        return purposeMajorTwo;
    }

    public void setPurposeMajorTwo(String purposeMajorTwo) {
        this.purposeMajorTwo = purposeMajorTwo;
    }

    public String getPurposeMajorThree() {
        return purposeMajorThree;
    }

    public void setPurposeMajorThree(String purposeMajorThree) {
        this.purposeMajorThree = purposeMajorThree;
    }

    public Long getAppositive() {
        return appositive;
    }

    public void setAppositive(Long appositive) {
        this.appositive = appositive;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("stuId", getStuId())
                .append("stuNo", getStuNo())
                .append("stuPassword", getStuPassword())
                .append("stuName", getStuName())
                .append("stuSex", getStuSex())
                .append("stuAddress", getStuAddress())
                .append("stuAge", getStuAge())
                .append("stuScore", getStuScore())
                .append("stuEmail", getStuEmail())
                .append("stuPhone", getStuPhone())
                .append("stuPostcode", getStuPostcode())
                .append("provinceName", getProvinceName())
                .append("cityName", getCityName())
                .append("ranking", getRanking())
                .append("physics", getPhysics())
                .append("chemistry", getChemistry())
                .append("biology", getBiology())
                .append("politics", getPolitics())
                .append("history", getHistory())
                .append("geography", getGeography())
                .append("optional", getOptional())
                .append("mbtiResult", getMbtiResult())
                .append("purposeAddressOne", getPurposeAddressOne())
                .append("purposeAddressTwo", getPurposeAddressTwo())
                .append("purposeAddressThree", getPurposeAddressThree())
                .append("purposeMajorOne", getPurposeMajorOne())
                .append("purposeMajorTwo", getPurposeMajorTwo())
                .append("purposeMajorThree", getPurposeMajorThree())
                .append("appositive", getAppositive())
                .toString();
    }
}
