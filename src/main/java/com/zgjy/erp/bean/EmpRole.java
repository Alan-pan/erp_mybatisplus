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
@TableName("t_emp_role")
public class EmpRole extends Model<EmpRole> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "erid", type = IdType.AUTO)
    private Integer erid;
    private Integer eid;
    private Integer rid;


    public Integer getErid() {
        return erid;
    }

    public void setErid(Integer erid) {
        this.erid = erid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Override
    protected Serializable pkVal() {
        return this.erid;
    }

    @Override
    public String toString() {
        return "EmpRole{" +
        ", erid=" + erid +
        ", eid=" + eid +
        ", rid=" + rid +
        "}";
    }
}
