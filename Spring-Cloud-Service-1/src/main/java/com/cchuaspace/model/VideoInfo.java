package com.cchuaspace.model;

public class VideoInfo {
    private String id;

    private Integer videoNumber;

    private Integer presentPrice;

    private String videoName;

    private String videoSrc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVideoNumber() {
        return videoNumber;
    }

    public void setVideoNumber(Integer videoNumber) {
        this.videoNumber = videoNumber;
    }

    public Integer getPresentPrice() {
        return presentPrice;
    }

    public void setPresentPrice(Integer presentPrice) {
        this.presentPrice = presentPrice;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoSrc() {
        return videoSrc;
    }

    public void setVideoSrc(String videoSrc) {
        this.videoSrc = videoSrc;
    }
}