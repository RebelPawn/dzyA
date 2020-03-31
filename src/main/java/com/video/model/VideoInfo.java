package com.video.model;

/**
 *@ClassName VideoInfo
 *@Description TODO
 *@Author dzy
 *@Date 2020/3/31 11:38 
 */
public class VideoInfo {

    private int videoInfoId;

    private int videoNum;

    private String fileName;

    private int videoLength;

    public int getVideoInfoId() {
        return videoInfoId;
    }

    public void setVideoInfoId(int videoInfoId) {
        this.videoInfoId = videoInfoId;
    }

    public int getVideoNum() {
        return videoNum;
    }

    public void setVideoNum(int videoNum) {
        this.videoNum = videoNum;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(int videoLength) {
        this.videoLength = videoLength;
    }
}
