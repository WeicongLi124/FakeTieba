package com.weicongli.demo.faketieba.module.home.model;

/**
 * @author: WeicongLi
 * @time: 2019/3/1 17:06
 * @email: 912220261@qq.com
 * @Function:
 */
public class CenterItemBean {
    private int avatar;
    private String name;
    private String barName;
    private String time;
    private String content;
    private int shareNum;
    private int chatNum;
    private int likeNum;
    private boolean hadLike;

    public CenterItemBean(int avatar, String name, String barName, String time, String content, int shareNum, int chatNum, int likeNum, boolean hadLike) {
        this.avatar = avatar;
        this.name = name;
        this.barName = barName;
        this.time = time;
        this.content = content;
        this.shareNum = shareNum;
        this.chatNum = chatNum;
        this.likeNum = likeNum;
        this.hadLike = hadLike;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getShareNum() {
        return shareNum;
    }

    public void setShareNum(int shareNum) {
        this.shareNum = shareNum;
    }

    public int getChatNum() {
        return chatNum;
    }

    public void setChatNum(int chatNum) {
        this.chatNum = chatNum;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public boolean isHadLike() {
        return hadLike;
    }

    public void setHadLike(boolean hadLike) {
        this.hadLike = hadLike;
    }
}
