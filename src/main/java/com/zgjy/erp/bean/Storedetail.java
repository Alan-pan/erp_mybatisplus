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
@TableName("t_storedetail")
public class Storedetail extends Model<Storedetail> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sdid", type = IdType.AUTO)
    private Integer sdid;
    private Integer sid;
    private Integer gid;
    private Integer num;
    private String gname;
    private String sname;


    public Integer getSdid() {
        return sdid;
    }

    public void setSdid(Integer sdid) {
        this.sdid = sdid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    protected Serializable pkVal() {
        return this.sdid;
    }

    @Override
    public String toString() {
        return "Storedetail{" +
        ", sdid=" + sdid +
        ", sid=" + sid +
        ", gid=" + gid +
        ", num=" + num +
        ", gname=" + gname +
        ", sname=" + sname +
        "}";
    }
}
