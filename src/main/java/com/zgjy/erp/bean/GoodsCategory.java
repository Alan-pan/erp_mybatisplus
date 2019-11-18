package com.zgjy.erp.bean;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("t_goods_category")
public class GoodsCategory extends Model<GoodsCategory> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "gcid", type = IdType.AUTO)
    private Integer gcid;
    private String name;


    public Integer getGcid() {
        return gcid;
    }

    public void setGcid(Integer gcid) {
        this.gcid = gcid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Serializable pkVal() {
        return this.gcid;
    }

    @Override
    public String toString() {
        return "GoodsCategory{" +
        ", gcid=" + gcid +
        ", name=" + name +
        "}";
    }
}
