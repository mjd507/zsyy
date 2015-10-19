package com.rainwii.zsyy.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/15 12:11
 */
public class DateUtils {

    /**
     * 获取当前日期
     *
     * @return yyyy-MM-dd
     */
    public static String getDate() {
        return getDate(new Date());
    }

    private static String getDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 是否是挂号时间（6:00 ~ 16:30）
     */
    public static boolean isRegisterTime() {
        Calendar calendarMorning = Calendar.getInstance();
        calendarMorning.set(Calendar.HOUR_OF_DAY, 6);
        calendarMorning.set(Calendar.MINUTE, 0);
        calendarMorning.set(Calendar.SECOND, 0);
        Date dateMorning = calendarMorning.getTime();
        Calendar calendarAfternoon = Calendar.getInstance();
        calendarAfternoon.set(Calendar.HOUR_OF_DAY, 16);
        calendarAfternoon.set(Calendar.MINUTE, 30);
        calendarAfternoon.set(Calendar.SECOND, 0);
        Date dateAfternoon = calendarAfternoon.getTime();
        Date dateNow = new Date();
        if (dateNow.before(dateAfternoon) && dateNow.after(dateMorning)) {
            return true;
        }
        return false;
    }

    /**
     * 是否挂上午的号
     */
    public static boolean isRegisterMorning() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 12);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date dateMorning = c.getTime();
        if (dateMorning.after(new Date())) {
            return true;
        }
        return false;
    }

    /**
     * 获取从今天以后，未来五天的日期
     *
     * @return List item 的内容格式：2015-10-16 (星期五)
     */
    public static List<String> getFutureFiveDays() {
        Date dateNow = new Date();
        List<String> list = new ArrayList<>();
        list.add(getFutureDay(dateNow, 1));
        list.add(getFutureDay(dateNow, 2));
        list.add(getFutureDay(dateNow, 3));
        list.add(getFutureDay(dateNow, 4));
        list.add(getFutureDay(dateNow, 5));
        return list;
    }

    /**
     * 获取当前日期后n天的日期
     */
    private static String getFutureDay(Date date, int dayAfter) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, dayAfter);
        Date newDate = calendar.getTime();
        String newDateStr = getDate(newDate);
        String dayOfWeek = whichDay(newDate);
        return newDateStr + " (" + dayOfWeek + ")";
    }

    /**
     * 判断指定日期是星期几
     */
    private static String whichDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String day = "";
        switch (dayOfWeek) {
            case Calendar.MONDAY:
                day = "星期一";
                break;
            case Calendar.TUESDAY:
                day = "星期二";
                break;
            case Calendar.WEDNESDAY:
                day = "星期三";
                break;
            case Calendar.THURSDAY:
                day = "星期四";
                break;
            case Calendar.FRIDAY:
                day = "星期五";
                break;
            case Calendar.SATURDAY:
                day = "星期六";
                break;
            case Calendar.SUNDAY:
                day = "星期日";
                break;
        }
        return day;
    }

}
