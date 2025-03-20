package com.zyx.common.core.domain.entity;

import com.zyx.common.annotation.Excel;
import com.zyx.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 考生志愿表对象 sys_volunteer
 *
 * @author 张银祥
 * @date 2021-08-17
 */
public class SysVolunteer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 志愿id */
    private Long volunteerId;

    /** 志愿序号 */
    @Excel(name = "志愿序号")
    private String volunteerNum;

    /** 考号关联考生 */
    @Excel(name = "考号关联考生")
    private String stuId;

    /** 报考学校 */
    @Excel(name = "报考学校")
    private String universityName;

    /** 报考专业 */
    @Excel(name = "报考专业")
    private String majorName;

    /** 院校对象 */
    private SysUniversity university;

    /** 专业对象 */
    private SysMajor major;

    public void setVolunteerId(Long volunteerId)
    {
        this.volunteerId = volunteerId;
    }

    public Long getVolunteerId()
    {
        return volunteerId;
    }
    public void setVolunteerNum(String volunteerNum)
    {
        this.volunteerNum = volunteerNum;
    }

    public String getVolunteerNum()
    {
        return volunteerNum;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public void setUniversityName(String universityName)
    {
        this.universityName = universityName;
    }

    public String getUniversityName()
    {
        return universityName;
    }
    public void setMajorName(String majorName)
    {
        this.majorName = majorName;
    }

    public String getMajorName()
    {
        return majorName;
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
                .append("volunteerId", getVolunteerId())
                .append("volunteerNum", getVolunteerNum())
                .append("stuId", getStuId())
                .append("universityName", getUniversityName())
                .append("majorName", getMajorName())
                .append("university", getUniversity())
                .append("major", getMajor())
                .toString();
    }
}
