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
@TableName("t_inventory")
public class Inventory extends Model<Inventory> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "inid", type = IdType.AUTO)
    private Integer inid;
    private Integer goodsid;
    private Integer storeid;
    private Integer num;
    private String type;
    private Date createtime;
    private Date checktime;
    private Integer creater;
    private Integer checker;
    private String state;
    private String remark;


    public Integer getInid() {
        return inid;
    }

    public void setInid(Integer inid) {
        this.inid = inid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
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

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    public Integer getChecker() {
        return checker;
    }

    public void setChecker(Integer checker) {
        this.checker = checker;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    protected Serializable pkVal() {
        return this.inid;
    }

    @Override
    public String toString() {
        return "Inventory{" +
        ", inid=" + inid +
        ", goodsid=" + goodsid +
        ", storeid=" + storeid +
        ", num=" + num +
        ", type=" + type +
        ", createtime=" + createtime +
        ", checktime=" + checktime +
        ", creater=" + creater +
        ", checker=" + checker +
        ", state=" + state +
        ", remark=" + remark +
        "}";
    }
}
