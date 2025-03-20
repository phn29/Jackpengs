package com.zyx.common.core.domain.entity;

import com.zyx.common.annotation.Excel;
import com.zyx.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户历史行为对象 sys_history
 *
 * @author 张银祥
 * @date 2022-01-16
 */
public class SysHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long historyId;

    /** 关联用户表 */
    @Excel(name = "关联用户表")
    private Long userId;

    /** 历史类型 0:专业，1:学校 */
    @Excel(name = "历史类型 0:专业，1:学校")
    private String historyType;

    /** 名称 */
    @Excel(name = "名称")
    private String historyName;

    /** 次数 */
    @Excel(name = "次数")
    private Long historyNumber;

    public void setHistoryId(Long historyId)
    {
        this.historyId = historyId;
    }

    public Long getHistoryId()
    {
        return historyId;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setHistoryType(String historyType)
    {
        this.historyType = historyType;
    }

    public String getHistoryType()
    {
        return historyType;
    }
    public void setHistoryName(String historyName)
    {
        this.historyName = historyName;
    }

    public String getHistoryName()
    {
        return historyName;
    }
    public void setHistoryNumber(Long historyNumber)
    {
        this.historyNumber = historyNumber;
    }

    public Long getHistoryNumber()
    {
        return historyNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("historyId", getHistoryId())
                .append("userId", getUserId())
                .append("historyType", getHistoryType())
                .append("historyName", getHistoryName())
                .append("historyNumber", getHistoryNumber())
                .append("createTime", getCreateTime())
                .toString();
    }
}
