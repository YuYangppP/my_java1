package com.yu.utils;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Tools.java
 * @Description TODO
 * @Date 2020/2/27 17:22
 */
public class Tools {

    public static Date stringToDate(String strdate) {


        //年月日，没有分时秒
        DateFormat df = DateFormat.getDateInstance();
        Date d = null;
        try {
            d = df.parse(strdate); //外国格式

        } catch (Exception e) {

            e.printStackTrace();
        }
        return d;

    }
}