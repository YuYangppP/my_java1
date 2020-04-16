package com.yu.vo;

import java.util.Date;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName BuMen.java
 * @Description TODO
 * @Date 2020/2/26 16:56
 */
public class BuMen {
    private int bid;
    private String bname;
    private Date createTime;
    private String leader;
    private String telephone;

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    @Override
    public String toString() {
        return "BuMen{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
