package com.weicongli.demo.faketieba.module.msg.model;

/**
 * @author: WeicongLi
 * @time: 2019/3/5 14:13
 * @email: 912220261@qq.com
 * @Function:
 */
public class MessageBean {
    private int avatar;
    private String name;
    private String time;
    private String reply;
    private String content;
    private String barName;

    public MessageBean(int avatar, String name, String time, String reply, String content, String barName) {
        this.avatar = avatar;
        this.name = name;
        this.time = time;
        this.reply = reply;
        this.content = content;
        this.barName = barName;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String replay) {
        this.reply = replay;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }
}
