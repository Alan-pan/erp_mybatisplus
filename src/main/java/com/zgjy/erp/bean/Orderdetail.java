package com.zgjy.erp.bean;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
@TableName("t_orderdetail")
public class Orderdetail extends Model<Orderdetail> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "odid", type = IdType.AUTO)
    private Integer odid;
    private Integer gid;
    private String gname;
    private BigDecimal price;
    private Integer num;
    private BigDecimal money;
    private Date endtime;
    private Integer ender;
    private Integer storeid;
    private String state;
    private Integer oid;


    public Integer getOdid() {
        return odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getEnder() {
        return ender;
    }

    public void setEnder(Integer ender) {
        this.ender = ender;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    @Override
    protected Serializable pkVal() {
        return this.odid;
    }

    @Override
    public String toString() {
        return "Orderdetail{" +
        ", odid=" + odid +
        ", gid=" + gid +
        ", gname=" + gname +
        ", price=" + price +
        ", num=" + num +
        ", money=" + money +
        ", endtime=" + endtime +
        ", ender=" + ender +
        ", storeid=" + storeid +
        ", state=" + state +
        ", oid=" + oid +
        "}";
    }
}
