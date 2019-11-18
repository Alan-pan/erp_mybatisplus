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
@TableName("t_dept")
public class Dept extends Model<Dept> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "did", type = IdType.AUTO)
    private Integer did;
    private String name;
    private String tel;


    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    protected Serializable pkVal() {
        return this.did;
    }

    @Override
    public String toString() {
        return "Dept{" +
        ", did=" + did +
        ", name=" + name +
        ", tel=" + tel +
        "}";
    }
}
