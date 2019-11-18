package com.zgjy.erp.bean;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("t_storeoper")
public class Storeoper extends Model<Storeoper> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "soid", type = IdType.AUTO)
    private Integer soid;
    private Integer empid;
    private Date opertime;
    private Integer storeid;
    private Integer goodsid;
    private Integer num;
    private String type;


    public Integer getSoid() {
        return soid;
    }

    public void setSoid(Integer soid) {
        this.soid = soid;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Date getOpertime() {
        return opertime;
    }

    public void setOpertime(Date opertime) {
        this.opertime = opertime;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected Serializable pkVal() {
        return this.soid;
    }

    @Override
    public String toString() {
        return "Storeoper{" +
        ", soid=" + soid +
        ", empid=" + empid +
        ", opertime=" + opertime +
        ", storeid=" + storeid +
        ", goodsid=" + goodsid +
        ", num=" + num +
        ", type=" + type +
        "}";
    }
}
