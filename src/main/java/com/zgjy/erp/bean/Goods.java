package com.zgjy.erp.bean;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
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
@TableName("t_goods")
public class Goods extends Model<Goods> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "gid", type = IdType.AUTO)
    private Integer gid;
    private String gname;
    private String origin;
    private String producter;
    private String unit;
    private BigDecimal inprice;
    private BigDecimal outprice;
    private Integer gcid;


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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getProducter() {
        return producter;
    }

    public void setProducter(String producter) {
        this.producter = producter;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getInprice() {
        return inprice;
    }

    public void setInprice(BigDecimal inprice) {
        this.inprice = inprice;
    }

    public BigDecimal getOutprice() {
        return outprice;
    }

    public void setOutprice(BigDecimal outprice) {
        this.outprice = outprice;
    }

    public Integer getGcid() {
        return gcid;
    }

    public void setGcid(Integer gcid) {
        this.gcid = gcid;
    }

    @Override
    protected Serializable pkVal() {
        return this.gid;
    }

    @Override
    public String toString() {
        return "Goods{" +
        ", gid=" + gid +
        ", gname=" + gname +
        ", origin=" + origin +
        ", producter=" + producter +
        ", unit=" + unit +
        ", inprice=" + inprice +
        ", outprice=" + outprice +
        ", gcid=" + gcid +
        "}";
    }
}
