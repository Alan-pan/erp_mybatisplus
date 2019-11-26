package com.zgjy.erp.api;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringConvertDate implements Converter<String, Date> {

    @Override
    public Date convert(String str) {
            System.out.println(str);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = sdf.parse(str);
                return date;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }
}