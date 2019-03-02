package com.weicongli.demo.faketieba.module.bar.model;

/**
 * @author: WeicongLi
 * @time: 2019/2/18 22:04
 * @email: 912220261@qq.com
 * @Function:
 */
public class BarDataBean {
    private String barNameL;
    private int barLevelL;
    private boolean isSignL;
    private boolean haveRight;
    private String barNameR;
    private int barLevelR;
    private boolean isSignR;
    private int type;

    public BarDataBean(int type) {
        this.type = type;
    }

    public BarDataBean(String barNameL, int barLevelL, boolean isSignL, boolean haveRight, int type) {
        this.barNameL = barNameL;
        this.barLevelL = barLevelL;
        this.isSignL = isSignL;
        this.haveRight = haveRight;
        this.type = type;
    }

    public BarDataBean(String barNameL, int barLevelL, boolean isSignL, boolean haveRight, String barNameR, int barLevelR, boolean isSignR, int type) {
        this.barNameL = barNameL;
        this.barLevelL = barLevelL;
        this.isSignL = isSignL;
        this.haveRight = haveRight;
        this.barNameR = barNameR;
        this.barLevelR = barLevelR;
        this.isSignR = isSignR;
        this.type = type;
    }

    public String getBarNameL() {
        return barNameL;
    }

    public void setBarNameL(String barNameL) {
        this.barNameL = barNameL;
    }

    public int getBarLevelL() {
        return barLevelL;
    }

    public void setBarLevelL(int barLevelL) {
        this.barLevelL = barLevelL;
    }

    public boolean isSignL() {
        return isSignL;
    }

    public void setSignL(boolean signL) {
        isSignL = signL;
    }

    public boolean isHaveRight() {
        return haveRight;
    }

    public void setHaveRight(boolean haveRight) {
        this.haveRight = haveRight;
    }

    public String getBarNameR() {
        return barNameR;
    }

    public void setBarNameR(String barNameR) {
        this.barNameR = barNameR;
    }

    public int getBarLevelR() {
        return barLevelR;
    }

    public void setBarLevelR(int barLevelR) {
        this.barLevelR = barLevelR;
    }

    public boolean isSignR() {
        return isSignR;
    }

    public void setSignR(boolean signR) {
        isSignR = signR;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
