package com.zyx.common.core.domain.entity;

import com.zyx.common.annotation.Excel;
import com.zyx.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 聊天记录对象 sys_chat
 *
 * @author zyx
 * @date 2022-02-03
 */
public class SysChat extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long chatId;

    /** 考生id */
    @Excel(name = "考生id")
    private String stuId;

    /** 咨询师id */
    @Excel(name = "咨询师id")
    private String expertId;

    /** 0预约中 1预约成功 */
    @Excel(name = "0预约中 1预约成功")
    private String state;

    /** 聊天记录 */
    @Excel(name = "聊天记录")
    private String content;

    /** 学生表 */
    private SysStudent student;

    /** 咨询师表 */
    private SysExpert expert;

    public void setChatId(Long chatId)
    {
        this.chatId = chatId;
    }

    public Long getChatId()
    {
        return chatId;
    }
    public void setStuId(String stuId)
    {
        this.stuId = stuId;
    }

    public String getStuId()
    {
        return stuId;
    }

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getState()
    {
        return state;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }

    public SysStudent getStudent() {
        return student;
    }

    public void setStudent(SysStudent student) {
        this.student = student;
    }

    public SysExpert getExpert() {
        return expert;
    }

    public void setExpert(SysExpert expert) {
        this.expert = expert;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("chatId", getChatId())
                .append("stuId", getStuId())
                .append("expertId", getExpertId())
                .append("state", getState())
                .append("content", getContent())
                .append("createTime", getCreateTime())
                .append("student", getStudent())
                .append("expert", getExpert())
                .toString();
    }
}