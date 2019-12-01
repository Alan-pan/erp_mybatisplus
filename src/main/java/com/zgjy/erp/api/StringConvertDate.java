package com.zgjy.erp.api;


import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringConvertDate implements Converter<String, Date> {

    @Override
    public Date convert(String str) {
            System.out.println("日期转换:"+str);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if(!StringUtils.isEmpty(str)){
                try {
                    Date date = sdf.parse(str);
                    return date;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
}