package com.zgjy.erp.bean;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName("v_storewarn")
public class StoreWarn {
    private Integer goodsid;
    private String goodsname;
    private Integer storenum;
    private Integer salenum;

    public StoreWarn() {
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Integer getStorenum() {
        return storenum;
    }

    public void setStorenum(Integer storenum) {
        this.storenum = storenum;
    }

    public Integer getSalenum() {
        return salenum;
    }

    public void setSalenum(Integer salenum) {
        this.salenum = salenum;
    }
}
