package com.silklee.common.utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@Component
public class KunyueDateUtil {


    public static DateTime changeGMT(Long timestamp) {
        return new DateTime(timestamp, TimeZone.getTimeZone(TimeZone.getTimeZone("GMT").getID()));
    }

    public static String getYear2SecondWith(DateTime dateTime) {
        return DateUtil.format(dateTime, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getYear2Second(DateTime dateTime) {
        return DateUtil.format(dateTime, "yyyyMMddHHmmss");
    }

    public static String getYear2Hour(DateTime dateTime) {
        return DateUtil.format(dateTime, "yyyyMMddHH");
    }

    public static String getYear2HourWith(DateTime dateTime) {
        return DateUtil.format(dateTime, "yyyy-MM-dd HH");
    }

    public static String getYear2Day(DateTime dateTime) {
        return DateUtil.format(dateTime, "yyyyMMdd");
    }


    public static Integer getSecondsInHour(DateTime dateTime) {
        return dateTime.minute() * 60 + dateTime.second();
    }


    public static String getHourMinute(DateTime dateTime) {
        return DateUtil.format(dateTime, "HH:mm");
    }

    public static String getMinuteSeconds(DateTime dateTime) {
        return DateUtil.format(dateTime, "mm:ss");
    }


    public static Integer getSecondsInHour(String time) {
        DateTime datetime = DateTime.of(time, "yyyy-MM-dd HH:mm:ss");
        return datetime.minute() * 60 + datetime.second();
    }

    public static String getMinuteSeconds(String time) {
        return DateUtil.format(DateTime.of(time, "yyyy-MM-dd HH:mm:ss"), "mm:ss");
    }

    /**
     * 根据时间获取一年的开始和结束月份
     *
     * @param time
     * @return
     */
    public static List<String> beginAndEndMouthOfYear(String time) {
        DateTime timeDate = DateTime.of(time, "yyyy");
        int start = DateUtil.beginOfYear(timeDate).month();
        int end = DateUtil.endOfYear(timeDate).month();
        List<String> list = new ArrayList<>(end + 1);
        int index = 0;
        for (int i = start; i <= end; i++) {
            index = i + 1;
            //单数的添加“0”
            if (StrUtil.length(String.valueOf(index)) < 2) {
                list.add(time + "0" + index);
            } else {
                list.add(time + index);
            }
        }
        return list;
    }


    /**
     * 根据时间获取某月的所有日期
     *
     * @param time
     * @return
     */
    public static List<String> beginAndEndDayOfMouth(String time) {
        DateTime timeDate = DateTime.of(time, "yyyyMM");
        int start = DateUtil.beginOfMonth(timeDate).dayOfMonth();
        int end = DateUtil.endOfMonth(timeDate).dayOfMonth();
        List<String> list = new ArrayList<>(end + 1);
        for (int i = start; i <= end; i++) {
            //单数的添加“0”
            if (StrUtil.length(String.valueOf(i)) < 2) {
                list.add(time + "0" + i);
            } else {
                list.add(time + i);
            }
        }
        return list;
    }

}
