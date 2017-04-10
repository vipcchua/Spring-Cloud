package com.cchuaspace.model;

public class BannerCategory {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 相册ID
    */
    private Integer albumId;

    /**
    * 相册名称
    */
    private String albumName;

    /**
    * 图片名称
    */
    private String name;

    /**
    * 链接地址
    */
    private String linkurl;

    /**
    * CDN地址
    */
    private String cdnurl;

    /**
    * 图片路径
    */
    private String imageUrl;

    /**
    * 网络图片路径
    */
    private String imageNetUrl;

    /**
    * 扩展名
    */
    private String ext;

    private Integer setBanner;

    /**
    * 宽
    */
    private String width;

    /**
    * 高
    */
    private String height;

    /**
    * 状态//radio/2,隐藏,1,显示
    */
    private Integer status;

    /**
    * 是否评论//radio/2,否,1,是
    */
    private Integer isComment;

    /**
    * 是否推荐：2 否 1 是
    */
    private Integer isRecommend;

    /**
    * 排序
    */
    private Integer sort;

    /**
    * 备注
    */
    private String remark;

    /**
    * 发布时间
    */
    private String publishTime;

    /**
    * 发布者
    */
    private String publishUser;

    /**
    * 更新时间
    */
    private String updateTime;

    /**
    * 更新者
    */
    private Integer updateId;

    /**
    * 创建时间
    */
    private String createTime;

    /**
    * 创建者
    */
    private Integer createId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
    }

    public String getCdnurl() {
        return cdnurl;
    }

    public void setCdnurl(String cdnurl) {
        this.cdnurl = cdnurl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageNetUrl() {
        return imageNetUrl;
    }

    public void setImageNetUrl(String imageNetUrl) {
        this.imageNetUrl = imageNetUrl;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Integer getSetBanner() {
        return setBanner;
    }

    public void setSetBanner(Integer setBanner) {
        this.setBanner = setBanner;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsComment() {
        return isComment;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getPublishUser() {
        return publishUser;
    }

    public void setPublishUser(String publishUser) {
        this.publishUser = publishUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }
}