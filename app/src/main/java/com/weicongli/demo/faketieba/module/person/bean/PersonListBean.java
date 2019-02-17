package com.weicongli.demo.faketieba.module.person.bean;


/**
 * @author: WeicongLi
 * @time: 2019/2/17 16:15
 * @email: 912220261@qq.com
 * @Function:
 */
public class PersonListBean {
    private int type;
    private int image;
    private String title;
    private int avatar;
    private String name;
    private String focus;
    private String fans;
    private String focusBars;
    private String tips;

    //头部
    public PersonListBean(int type, String name, int avatar) {
        this.type = type;
        this.avatar = avatar;
        this.name = name;
    }

    //按钮
    public PersonListBean(int type, String focus, String fans, String focusBars, String tips) {
        this.type = type;
        this.focus = focus;
        this.fans = fans;
        this.focusBars = focusBars;
        this.tips = tips;
    }

    //ad
    public PersonListBean(int type) {
        this.type = type;
    }

    //列表选项
    public PersonListBean(int type, int image, String title) {
        this.type = type;
        this.image = image;
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getFocusBars() {
        return focusBars;
    }

    public void setFocusBars(String focusBars) {
        this.focusBars = focusBars;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
