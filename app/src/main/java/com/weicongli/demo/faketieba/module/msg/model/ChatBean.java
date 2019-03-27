package com.weicongli.demo.faketieba.module.msg.model;

/**
 * @author: WeicongLi
 * @time: 2019/3/27 19:49
 * @email: 912220261@qq.com
 * @Function:
 */
public class ChatBean {
    private int image;
    private String title;
    private String time;
    private String content;
    private String name;

    public ChatBean(int image, String title, String name, String content,  String time) {
        this.image = image;
        this.title = title;
        this.time = time;
        this.content = content;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
