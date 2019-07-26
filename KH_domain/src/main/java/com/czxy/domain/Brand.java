package com.czxy.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: 传智新星
 * @Date: 2019/7/7 00:19
 * @Description:
 */
@Table(name = "tbl_brand")
public class Brand {

    @Id
    private String bid;

    private String bname;

    private Date addtime;

    @Override
    public String toString() {
        return "Brand{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", addtime=" + addtime +
                '}';
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Brand() {
    }

    public Brand(String bid, String bname, Date addtime) {
        this.bid = bid;
        this.bname = bname;
        this.addtime = addtime;
    }
}