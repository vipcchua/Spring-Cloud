package com.cchuaspace.model;

import java.util.Date;

public class HomepageBanner {
    private String id;

    private String activityName;

    private Date startTime;

    private Date endTime;

    /**
    * 发布时间
    */
    private Date releaseTime;

    /**
    * 活动图片
    */
    private String activeImg;

    private String link;

    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getActiveImg() {
        return activeImg;
    }

    public void setActiveImg(String activeImg) {
        this.activeImg = activeImg;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}