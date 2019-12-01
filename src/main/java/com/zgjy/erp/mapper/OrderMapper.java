package com.zgjy.erp.mapper;

import com.zgjy.erp.bean.Order;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
public interface OrderMapper extends BaseMapper<Order> {
    List<Map> querySaleByPerMonth(@Param("year") String year);
    public List<HashMap> queryOrder(String starttime, String endtime);
}
