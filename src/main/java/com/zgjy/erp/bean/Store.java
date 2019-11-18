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
@TableName("t_store")
public class Store extends Model<Store> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;
    private String name;
    private Integer empid;


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    @Override
    protected Serializable pkVal() {
        return this.sid;
    }

    @Override
    public String toString() {
        return "Store{" +
        ", sid=" + sid +
        ", name=" + name +
        ", empid=" + empid +
        "}";
    }
}
