package com.zyx.common.core.domain.entity;

import com.zyx.common.annotation.Excel;
import com.zyx.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 高考时间轴表对象 sys_timeaxis
 * 
 * @author 张银祥
 * @date 2021-05-31
 */
public class SysTimeaxis extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 时间轴id */
    private Long timeAxisId;

    /** 月份 */
    @Excel(name = "月份")
    private String month;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    public void setTimeAxisId(Long timeAxisId) 
    {
        this.timeAxisId = timeAxisId;
    }

    public Long getTimeAxisId() 
    {
        return timeAxisId;
    }
    public void setMonth(String month) 
    {
        this.month = month;
    }

    public String getMonth() 
    {
        return month;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("timeAxisId", getTimeAxisId())
            .append("month", getMonth())
            .append("content", getContent())
            .toString();
    }
}
