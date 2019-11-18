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
@TableName("t_emp")
public class Emp extends Model<Emp> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "eid", type = IdType.AUTO)
    private Integer eid;
    private String username;
    private String password;
    private String name;
    private Integer sex;
    private String email;
    private String tel;
    private String address;
    private Date birthday;
    private Integer did;


    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Override
    protected Serializable pkVal() {
        return this.eid;
    }

    @Override
    public String toString() {
        return "Emp{" +
        ", eid=" + eid +
        ", username=" + username +
        ", password=" + password +
        ", name=" + name +
        ", sex=" + sex +
        ", email=" + email +
        ", tel=" + tel +
        ", address=" + address +
        ", birthday=" + birthday +
        ", did=" + did +
        "}";
    }
}
