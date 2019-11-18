package com.zgjy.erp.bean;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("t_order")
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "oid", type = IdType.AUTO)
    private Integer oid;
    private Date createtime;
    private Date checktime;
    private Date starttime;
    private Date endtime;
    private String type;
    private Integer creater;
    @TableField("createrName")
    private String createrName;
    private Integer checker;
    @TableField("checkerName")
    private String checkerName;
    private Integer starter;
    @TableField("starterName")
    private String starterName;
    private Integer ender;
    @TableField("enderName")
    private String enderName;
    private Integer supplier;
    @TableField("supplierName")
    private String supplierName;
    private BigDecimal totalmoney;
    private Integer state;
    private Integer waybillsno;


    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public Integer getChecker() {
        return checker;
    }

    public void setChecker(Integer checker) {
        this.checker = checker;
    }

    public String getCheckerName() {
        return checkerName;
    }

    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }

    public Integer getStarter() {
        return starter;
    }

    public void setStarter(Integer starter) {
        this.starter = starter;
    }

    public String getStarterName() {
        return starterName;
    }

    public void setStarterName(String starterName) {
        this.starterName = starterName;
    }

    public Integer getEnder() {
        return ender;
    }

    public void setEnder(Integer ender) {
        this.ender = ender;
    }

    public String getEnderName() {
        return enderName;
    }

    public void setEnderName(String enderName) {
        this.enderName = enderName;
    }

    public Integer getSupplier() {
        return supplier;
    }

    public void setSupplier(Integer supplier) {
        this.supplier = supplier;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public BigDecimal getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(BigDecimal totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getWaybillsno() {
        return waybillsno;
    }

    public void setWaybillsno(Integer waybillsno) {
        this.waybillsno = waybillsno;
    }

    @Override
    protected Serializable pkVal() {
        return this.oid;
    }

    @Override
    public String toString() {
        return "Order{" +
        ", oid=" + oid +
        ", createtime=" + createtime +
        ", checktime=" + checktime +
        ", starttime=" + starttime +
        ", endtime=" + endtime +
        ", type=" + type +
        ", creater=" + creater +
        ", createrName=" + createrName +
        ", checker=" + checker +
        ", checkerName=" + checkerName +
        ", starter=" + starter +
        ", starterName=" + starterName +
        ", ender=" + ender +
        ", enderName=" + enderName +
        ", supplier=" + supplier +
        ", supplierName=" + supplierName +
        ", totalmoney=" + totalmoney +
        ", state=" + state +
        ", waybillsno=" + waybillsno +
        "}";
    }
}
