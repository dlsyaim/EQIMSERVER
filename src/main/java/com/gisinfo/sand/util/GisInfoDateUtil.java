package com.gisinfo.sand.util;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class GisInfoDateUtil {

    //region java8 Time
    /**
     * 将LocalDateTime 格式化输出string
     *
     * @return
     */
    public static String getTimeStr(LocalDateTime time, String format) {
        if (StringUtils.isEmpty(format)) {
            format = ConstantsUtil.DATE_TIME_FORMATTER;
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        return time.format(df);
    }
    //endregion

    /**
     * timestamp 转为 date
     * @param timestamp
     * @return
     */
    public static Date timeStampToDate(Timestamp timestamp) {
        if (null == timestamp) {
            return null;
        }
        Date date = null;
        try {
            date = timestamp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 返回当前日期的前一天日期
     * Created by 86173 on 2019-07-24.
     */
    public static String returnLastMonth(){
        Calendar ca = Calendar.getInstance();//得到一个Calendar的实例
        ca.setTime(new Date()); //设置时间为当前时间
        ca.add(Calendar.DATE, -1);  //当前日期减去一天
        Date lastMonth = ca.getTime();  //减去一天后得到的日期
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");   //设置需要转换的格式
        String startDate = sf.format(lastMonth);    //将Date类型转换成String类型
        return startDate;
    }

    /**
     * 获得年份
     * @param date
     * @return
     */
    public static String getYear(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return getYear(c);
    }

    /**
     * 获得双位数月份
     * @param calendar
     * @return
     */
    public static String getYear(Calendar calendar) {
        if (null == calendar) {
            calendar = Calendar.getInstance();
        }
        return calendar.get(Calendar.YEAR) + ConstantsUtil.EMPTY_VALUE;
    }

    /**
     * 获得双位数月份
     * @param date
     * @return
     */
    public static String getMonth(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return getMonth(c);
    }

    /**
     * 获得双位数月份
     * @param calendar
     * @return
     */
    public static String getMonth(Calendar calendar) {
        if (null == calendar) {
            calendar = Calendar.getInstance();
        }
        int month = calendar.get(Calendar.MONTH) + 1;
        return month < 10 ? ConstantsUtil.STR_0 + month : month + ConstantsUtil.EMPTY_VALUE;
    }

    /**
     * 获得双位数日期
     * @param date
     * @return
     */
    public static String getDay(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return getDay(c);
    }

    /**
     * 获得双位数日期
     * @param calendar
     * @return
     */
    public static String getDay(Calendar calendar) {
        if (null == calendar) {
            calendar = Calendar.getInstance();
        }
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return day < 10 ? ConstantsUtil.STR_0 + day : day + ConstantsUtil.EMPTY_VALUE;
    }

    /**
     * 获得中文年月日
     * @param date
     * @return
     */
    public static String getCHNDate(Date date) {
        if (null == date) {
            date = new Date();
        }
        return getYear(date) + "年" + getMonth(date) + "月" + getDay(date) + "日";
    }

    /**
     * 获得中文年月日
     * @param date
     * @return
     */
    public static String getCHNNoYear(Date date) {
        if (null == date) {
            date = new Date();
        }
        return getMonth(date) + "月" + getDay(date) + "日";
    }

}
