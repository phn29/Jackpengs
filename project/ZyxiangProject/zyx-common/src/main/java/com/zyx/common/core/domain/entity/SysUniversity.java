package com.zyx.common.core.domain.entity;

import com.zyx.common.annotation.Excel;
import com.zyx.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 院校管理对象 sys_university
 *
 * @author 张银祥
 * @date 2021-05-26
 */
public class SysUniversity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 院校id主键 */
    private Long universityId;

    /** 院校名称 */
    @Excel(name = "院校名称")
    private String universityName;

    /** 学校标识码，全国唯一 */
    @Excel(name = "学校标识码，全国唯一")
    private String universityIdCode;

    /** 院校类型 */
    @Excel(name = "院校类型")
    private String universityType;

    /** 学校招生代码，全国唯一 */
    @Excel(name = "学校招生代码，全国唯一")
    private String universityCode;

    /** 院校地址 */
    @Excel(name = "院校地址")
    private String universityAddress;

    /** 院校具体信息 */
    @Excel(name = "院校具体信息")
    private String universityInformation;

    /** 院校层次 */
    @Excel(name = "院校层次")
    private String universityLevel;

    /** 院校性质 */
    @Excel(name = "院校性质")
    private String universityNature;

    /** 院校图片 */
    @Excel(name = "院校图片")
    private String universityBadge;

    /** 学校官网 */
    @Excel(name = "学校官网")
    private String universityWebsite;

    /** 学校电话 */
    @Excel(name = "学校电话")
    private String universityPhone;

    /** 招生办邮箱 */
    @Excel(name = "招生办邮箱")
    private String universityEmail;

    /** 隶属于 */
    @Excel(name = "隶属于")
    private String belong;

    /** 重点学科 */
    @Excel(name = "重点学科")
    private Long numSubject;

    /** 硕士点 */
    @Excel(name = "硕士点")
    private Long numMaster;

    /** 博士点 */
    @Excel(name = "博士点")
    private Long numDoctor;

    /** 院士人数 */
    @Excel(name = "院士人数")
    private Long numAcademician;

    /** 藏书数量 */
    @Excel(name = "藏书数量")
    private String numLibrary;

    /** 重点实验室数量 */
    @Excel(name = "重点实验室数量")
    private Long numLab;

    /** 所属省份 */
    @Excel(name = "所属省份")
    private String provinceName;

    /** 所属城市 */
    @Excel(name = "所属城市")
    private String cityName;

    /** 所属市区 */
    @Excel(name = "所属市区")
    private String townName;

    /** 创办年份 */
    @Excel(name = "创办年份")
    private String createDate;

    /** 占地面积，单位亩 */
    @Excel(name = "占地面积，单位亩")
    private Long area;

    /** 校园图片 */
    @Excel(name = "校园图片")
    private String universityPicture;

    /** 院校排名 */
    @Excel(name = "院校排名")
    private String ranking;

    /** 是否985 1是2否 */
    @Excel(name = "是否985 1是2否")
    private String f985;

    /** 是否211 1是2否 */
    @Excel(name = "是否211 1是2否")
    private String f211;

    /** 简称 */
    @Excel(name = "简称")
    private String shortName;

    /** 原名 */
    @Excel(name = "原名")
    private String oldName;

    /** 招生办网址 */
    @Excel(name = "招生办网址")
    private String site;

    /** 是否为双一流 */
    @Excel(name = "是否为双一流")
    private String dualClassName;

    /** 院校识别 */
    @Excel(name = "院校识别")
    private String universityIdentification;

    /** 访问次数 */
    @Excel(name = "访问次数")
    private Integer visitNumber;

    /** 招生计划数据 */
    private SysPlan plan;

    public void setUniversityId(Long universityId)
    {
        this.universityId = universityId;
    }

    public Long getUniversityId()
    {
        return universityId;
    }
    public void setUniversityName(String universityName)
    {
        this.universityName = universityName;
    }

    public String getUniversityName()
    {
        return universityName;
    }
    public void setUniversityIdCode(String universityIdCode)
    {
        this.universityIdCode = universityIdCode;
    }

    public String getUniversityIdCode()
    {
        return universityIdCode;
    }
    public void setUniversityType(String universityType)
    {
        this.universityType = universityType;
    }

    public String getUniversityType()
    {
        return universityType;
    }
    public void setUniversityCode(String universityCode)
    {
        this.universityCode = universityCode;
    }

    public String getUniversityCode()
    {
        return universityCode;
    }
    public void setUniversityAddress(String universityAddress)
    {
        this.universityAddress = universityAddress;
    }

    public String getUniversityAddress()
    {
        return universityAddress;
    }
    public void setUniversityInformation(String universityInformation)
    {
        this.universityInformation = universityInformation;
    }

    public String getUniversityInformation()
    {
        return universityInformation;
    }
    public void setUniversityLevel(String universityLevel)
    {
        this.universityLevel = universityLevel;
    }

    public String getUniversityLevel()
    {
        return universityLevel;
    }
    public void setUniversityNature(String universityNature)
    {
        this.universityNature = universityNature;
    }

    public String getUniversityNature()
    {
        return universityNature;
    }
    public void setUniversityBadge(String universityBadge)
    {
        this.universityBadge = universityBadge;
    }

    public String getUniversityBadge()
    {
        return universityBadge;
    }
    public void setUniversityWebsite(String universityWebsite)
    {
        this.universityWebsite = universityWebsite;
    }

    public String getUniversityWebsite()
    {
        return universityWebsite;
    }
    public void setUniversityPhone(String universityPhone)
    {
        this.universityPhone = universityPhone;
    }

    public String getUniversityPhone()
    {
        return universityPhone;
    }
    public void setUniversityEmail(String universityEmail)
    {
        this.universityEmail = universityEmail;
    }

    public String getUniversityEmail()
    {
        return universityEmail;
    }
    public void setBelong(String belong)
    {
        this.belong = belong;
    }

    public String getBelong()
    {
        return belong;
    }
    public void setNumSubject(Long numSubject)
    {
        this.numSubject = numSubject;
    }

    public Long getNumSubject()
    {
        return numSubject;
    }
    public void setNumMaster(Long numMaster)
    {
        this.numMaster = numMaster;
    }

    public Long getNumMaster()
    {
        return numMaster;
    }
    public void setNumDoctor(Long numDoctor)
    {
        this.numDoctor = numDoctor;
    }

    public Long getNumDoctor()
    {
        return numDoctor;
    }
    public void setNumAcademician(Long numAcademician)
    {
        this.numAcademician = numAcademician;
    }

    public Long getNumAcademician()
    {
        return numAcademician;
    }
    public void setNumLibrary(String numLibrary)
    {
        this.numLibrary = numLibrary;
    }

    public String getNumLibrary()
    {
        return numLibrary;
    }
    public void setNumLab(Long numLab)
    {
        this.numLab = numLab;
    }

    public Long getNumLab()
    {
        return numLab;
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
    public void setTownName(String townName)
    {
        this.townName = townName;
    }

    public String getTownName()
    {
        return townName;
    }
    public void setCreateDate(String createDate)
    {
        this.createDate = createDate;
    }

    public String getCreateDate()
    {
        return createDate;
    }
    public void setArea(Long area)
    {
        this.area = area;
    }

    public Long getArea()
    {
        return area;
    }
    public void setUniversityPicture(String universityPicture)
    {
        this.universityPicture = universityPicture;
    }

    public String getUniversityPicture()
    {
        return universityPicture;
    }
    public void setRanking(String ranking)
    {
        this.ranking = ranking;
    }

    public String getRanking()
    {
        return ranking;
    }
    public void setF985(String f985)
    {
        this.f985 = f985;
    }

    public String getF985()
    {
        return f985;
    }
    public void setF211(String f211)
    {
        this.f211 = f211;
    }

    public String getF211()
    {
        return f211;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setOldName(String oldName)
    {
        this.oldName = oldName;
    }

    public String getOldName()
    {
        return oldName;
    }
    public void setSite(String site)
    {
        this.site = site;
    }

    public String getSite()
    {
        return site;
    }
    public void setDualClassName(String dualClassName)
    {
        this.dualClassName = dualClassName;
    }

    public String getDualClassName()
    {
        return dualClassName;
    }

    public String getUniversityIdentification() {
        return universityIdentification;
    }

    public void setUniversityIdentification(String universityIdentification) {
        this.universityIdentification = universityIdentification;
    }

    public Integer getVisitNumber() {
        return visitNumber;
    }

    public void setVisitNumber(Integer visitNumber) {
        this.visitNumber = visitNumber;
    }

    public SysPlan getPlan() {
        return plan;
    }

    public void setPlan(SysPlan plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("universityId", getUniversityId())
                .append("universityName", getUniversityName())
                .append("universityIdCode", getUniversityIdCode())
                .append("universityType", getUniversityType())
                .append("universityCode", getUniversityCode())
                .append("universityAddress", getUniversityAddress())
                .append("universityInformation", getUniversityInformation())
                .append("universityLevel", getUniversityLevel())
                .append("universityNature", getUniversityNature())
                .append("universityBadge", getUniversityBadge())
                .append("universityWebsite", getUniversityWebsite())
                .append("universityPhone", getUniversityPhone())
                .append("universityEmail", getUniversityEmail())
                .append("belong", getBelong())
                .append("numSubject", getNumSubject())
                .append("numMaster", getNumMaster())
                .append("numDoctor", getNumDoctor())
                .append("numAcademician", getNumAcademician())
                .append("numLibrary", getNumLibrary())
                .append("numLab", getNumLab())
                .append("provinceName", getProvinceName())
                .append("cityName", getCityName())
                .append("townName", getTownName())
                .append("createDate", getCreateDate())
                .append("area", getArea())
                .append("universityPicture", getUniversityPicture())
                .append("ranking", getRanking())
                .append("f985", getF985())
                .append("f211", getF211())
                .append("shortName", getShortName())
                .append("oldName", getOldName())
                .append("site", getSite())
                .append("dualClassName", getDualClassName())
                .append("universityIdentification", getUniversityIdentification())
                .append("plan", getPlan())
                .append("visitNumber", getVisitNumber())
                .toString();
    }
}