package com.zyx.common.core.domain.entity;

import com.zyx.common.annotation.Excel;
import com.zyx.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 热点新闻表对象 sys_host
 * 
 * @author 张银祥
 * @date 2021-05-29
 */
public class SysHost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 热点新闻id */
    private Long hostId;

    /** 热点新闻标题 */
    @Excel(name = "热点新闻标题")
    private String hostTitle;

    /** 热点新闻作者 */
    @Excel(name = "热点新闻作者")
    private String hostAuthor;

    /** 热点新闻内容 */
    @Excel(name = "热点新闻内容")
    private String hostContent;

    /** 热点新闻来源 */
    @Excel(name = "热点新闻来源")
    private String hostSource;

    /** 热点新闻时间 */
    @Excel(name = "热点新闻时间")
    private Date hostTime;

    /** 热点新闻图片 */
    private String hostImg;

    /** 热点新闻图片 */
    private String hostVideo;

    public void setHostId(Long hostId) 
    {
        this.hostId = hostId;
    }

    public Long getHostId() 
    {
        return hostId;
    }
    public void setHostTitle(String hostTitle) 
    {
        this.hostTitle = hostTitle;
    }

    public String getHostTitle() 
    {
        return hostTitle;
    }

    public String getHostAuthor() {
        return hostAuthor;
    }

    public void setHostAuthor(String hostAuthor) {
        this.hostAuthor = hostAuthor;
    }

    public void setHostContent(String hostContent)
    {
        this.hostContent = hostContent;
    }

    public String getHostContent() 
    {
        return hostContent;
    }

    public String getHostSource() {
        return hostSource;
    }

    public void setHostSource(String hostSource) {
        this.hostSource = hostSource;
    }

    public Date getHostTime() {
        return hostTime;
    }

    public void setHostTime(Date hostTime) {
        this.hostTime = hostTime;
    }

    public void setHostImg(String hostImg)
    {
        this.hostImg = hostImg;
    }

    public String getHostImg() 
    {
        return hostImg;
    }

    public String getHostVideo() {
        return hostVideo;
    }

    public void setHostVideo(String hostVideo) {
        this.hostVideo = hostVideo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("hostId", getHostId())
                .append("hostTitle", getHostTitle())
                .append("hostAuthor", getHostAuthor())
                .append("hostContent", getHostContent())
                .append("hostSource", getHostSource())
                .append("hostTime", getHostTime())
                .append("hostImg", getHostImg())
                .append("hostVideo", getHostVideo())
                .toString();
    }
}
