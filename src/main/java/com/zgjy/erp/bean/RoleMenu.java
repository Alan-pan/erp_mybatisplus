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
@TableName("t_role_menu")
public class RoleMenu extends Model<RoleMenu> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "rmid", type = IdType.AUTO)
    private Integer rmid;
    private Integer rid;
    private Integer mid;


    public Integer getRmid() {
        return rmid;
    }

    public void setRmid(Integer rmid) {
        this.rmid = rmid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    @Override
    protected Serializable pkVal() {
        return this.rmid;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
        ", rmid=" + rmid +
        ", rid=" + rid +
        ", mid=" + mid +
        "}";
    }
}
