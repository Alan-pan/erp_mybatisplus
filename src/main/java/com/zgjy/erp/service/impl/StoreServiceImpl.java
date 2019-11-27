package com.zgjy.erp.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.zgjy.erp.api.MailHelper;
import com.zgjy.erp.bean.Store;
import com.zgjy.erp.bean.StoreWarn;
import com.zgjy.erp.mapper.StoreMapper;
import com.zgjy.erp.mapper.StoreWarnMapper;
import com.zgjy.erp.service.StoreService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements StoreService {
    @Autowired
    StoreMapper mapper;
    @Autowired
    StoreWarnMapper swMapper;
    @Autowired
    MailHelper mailHelper;
    @Override
    public List<StoreWarn> queryStoreWarn(Page page) {
        return mapper.queryStoreWarn(page);
    }

    public Integer sendEmail(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        List<StoreWarn> list = swMapper.selectList(null);
        if (list != null && list.size()>0) {
            int _count = list == null ? 0 : list.size();
            String count = Integer.toString(_count);
            try {

                mailHelper.sendMail("294332049@qq.com", "1806615243@qq.com", "erp系统[time]".replace("time", time), "现在有[count]类商品缺货".replace("count", count));
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
            return 1;
        }
        return 2;
    }
}
