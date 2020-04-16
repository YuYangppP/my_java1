package com.yu.vo;

import java.util.Date;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @Date 2020/2/25 13:47
 */
public class User {
    private int uid;
    private String name;
    private String number;
    private int bmid;
    private BuMen buMen;

    public BuMen getBuMen() {
        return buMen;
    }

    public void setBuMen(BuMen buMen) {
        this.buMen = buMen;
    }

    public int getBmid() {
        return bmid;
    }

    public void setBmid(int bmid) {
        this.bmid = bmid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", bmid=" + bmid +
                ", buMen=" + buMen +
                '}';
    }
}
