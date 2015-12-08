package com.tn.code;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by zhangjian5 on 2015/12/3.
 * 问候语
 */
public class Init {

    /**
     * 字符串的日期格式的计算
     */
    public int daysBetween(String smdate, String bdate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(smdate));
            long time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(bdate));
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            return Integer.parseInt(String.valueOf(between_days));
        } catch (Exception e) {
            System.out.println("parse date Exception");
            return 0;
        }
    }

    public  static void main(String[]args)
    {
        System.out.print(new Init().daysBetween("2015-12-1", "2015-12-30"));

    }

}