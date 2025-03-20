package com.zyx.common.core.domain.entity;

import com.zyx.common.annotation.Excel;
import com.zyx.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 专家表对象 sys_expert
 *
 * @author zyx
 * @date 2022-02-08
 */
public class SysExpert extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专家id */
    private Long expertId;

    /** 专家姓名 */
    @Excel(name = "专家姓名")
    private String expertName;

    /** 专家用户名 */
    @Excel(name = "专家用户名")
    private String expertUser;

    /** 密码 */
    @Excel(name = "密码")
    private String expertPassword;

    /** 专家年龄 */
    @Excel(name = "专家年龄")
    private String expertAge;

    /** 专家性别 0男，1女，2未知 */
    @Excel(name = "专家性别 0男，1女，2未知")
    private String expertSex;

    /** 专家头像 */
    @Excel(name = "专家头像")
    private String expertAvatar;

    /** 专家标签 */
    @Excel(name = "专家标签")
    private Long expertFlag;

    /** 专家介绍 */
    @Excel(name = "专家介绍")
    private String expertInfo;

    public void setExpertId(Long expertId)
    {
        this.expertId = expertId;
    }

    public Long getExpertId()
    {
        return expertId;
    }
    public void setExpertName(String expertName)
    {
        this.expertName = expertName;
    }

    public String getExpertName()
    {
        return expertName;
    }
    public void setExpertUser(String expertUser)
    {
        this.expertUser = expertUser;
    }

    public String getExpertUser()
    {
        return expertUser;
    }
    public void setExpertPassword(String expertPassword)
    {
        this.expertPassword = expertPassword;
    }

    public String getExpertPassword()
    {
        return expertPassword;
    }
    public void setExpertAge(String expertAge)
    {
        this.expertAge = expertAge;
    }

    public String getExpertAge()
    {
        return expertAge;
    }
    public void setExpertSex(String expertSex)
    {
        this.expertSex = expertSex;
    }

    public String getExpertSex()
    {
        return expertSex;
    }
    public void setExpertAvatar(String expertAvatar)
    {
        this.expertAvatar = expertAvatar;
    }

    public String getExpertAvatar()
    {
        return expertAvatar;
    }
    public void setExpertFlag(Long expertFlag)
    {
        this.expertFlag = expertFlag;
    }

    public Long getExpertFlag()
    {
        return expertFlag;
    }
    public void setExpertInfo(String expertInfo)
    {
        this.expertInfo = expertInfo;
    }

    public String getExpertInfo()
    {
        return expertInfo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("expertId", getExpertId())
                .append("expertName", getExpertName())
                .append("expertUser", getExpertUser())
                .append("expertPassword", getExpertPassword())
                .append("expertAge", getExpertAge())
                .append("expertSex", getExpertSex())
                .append("expertAvatar", getExpertAvatar())
                .append("expertFlag", getExpertFlag())
                .append("expertInfo", getExpertInfo())
                .toString();
    }
}