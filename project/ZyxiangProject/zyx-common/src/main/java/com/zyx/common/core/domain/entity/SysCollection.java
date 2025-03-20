package com.zyx.common.core.domain.entity;

import com.zyx.common.annotation.Excel;
import com.zyx.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户收藏记录对象 sys_collection
 *
 * @author zyx
 * @date 2022-03-30
 */
public class SysCollection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long stuId;

    /** 类型（0专业 1院校） */
    @Excel(name = "类型", readConverterExp = "0=专业,1=院校")
    private String collectionType;

    /** 名字 */
    @Excel(name = "名字")
    private String collectionName;

    /** 收藏数据的id */
    @Excel(name = "收藏数据的id")
    private String collectionId;

    private SysUniversity university;

    private SysMajor major;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setStuId(Long stuId)
    {
        this.stuId = stuId;
    }

    public Long getStuId()
    {
        return stuId;
    }
    public void setCollectionType(String collectionType)
    {
        this.collectionType = collectionType;
    }

    public String getCollectionType()
    {
        return collectionType;
    }
    public void setCollectionName(String collectionName)
    {
        this.collectionName = collectionName;
    }

    public String getCollectionName()
    {
        return collectionName;
    }
    public void setCollectionId(String collectionId)
    {
        this.collectionId = collectionId;
    }

    public String getCollectionId()
    {
        return collectionId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("stuId", getStuId())
                .append("collectionType", getCollectionType())
                .append("collectionName", getCollectionName())
                .append("collectionId", getCollectionId())
                .append("createTime", getCreateTime())
                .append("university", getUniversity())
                .append("major", getMajor())
                .toString();
    }
}
