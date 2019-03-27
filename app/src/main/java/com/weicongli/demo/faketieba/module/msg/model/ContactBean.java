package com.weicongli.demo.faketieba.module.msg.model;

/**
 * @author: WeicongLi
 * @time: 2019/3/27 21:20
 * @email: 912220261@qq.com
 * @Function:
 */
public class ContactBean {
    private int avatar;
    private String name;

    public ContactBean(int avatar, String name) {
        this.avatar = avatar;
        this.name = name;
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
}
