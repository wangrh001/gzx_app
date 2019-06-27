package com.bangnd.util.date;

import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.exception.AppException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

    public static String DATETIME_PATTERN_DATE = "yyyy-MM-dd";
    public static String DATETIME_PATTERN_TIME = "yyyy-MM-dd hh:mm:ss";
    public static String DATETIME_PATTERN_YEARMONTH = "yyyyMM";


    public static float getDaysByBetweenDates(Date startDate, Date endDate) {
        float days = 0;
        if (startDate.after(endDate) || startDate == null || endDate == null) {
            return days;
        }

        long time1 = startDate.getTime();
        long time2 = endDate.getTime();

        long diff;
        if (time1 < time2) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        days = (int) (diff / (24 * 60 * 60 * 1000)) + 1;
        return days;

    }

    public static Date getMonthStart(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.DATETIME_PATTERN_DATE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        String firstDayString = format.format(calendar.getTime()) + " 00:00:00";
        SimpleDateFormat format2 = new SimpleDateFormat(DateUtil.DATETIME_PATTERN_TIME);
        Date firstDayDate = new Date();
        try {
            firstDayDate = format2.parse(firstDayString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return firstDayDate;
    }

    public static Date getMonthEnd(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.DATETIME_PATTERN_DATE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        String endDateString = format.format(calendar.getTime()) + " 23:59:59";
        SimpleDateFormat format2 = new SimpleDateFormat(DateUtil.DATETIME_PATTERN_TIME);
        Date endDayDate = new Date();
        try {
            endDayDate = format2.parse(endDateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endDayDate;
    }

    public static Date getMonthStart(String yearMonth) {
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.DATETIME_PATTERN_YEARMONTH);
        Date firstDayDate = new Date();
        try {
            Date date = format.parse(yearMonth);
            firstDayDate = getMonthStart(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return firstDayDate;
    }

    public static Date getMonthEnd(String yearMonth) {
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.DATETIME_PATTERN_YEARMONTH);
        Date endDate = new Date();
        try {
            Date date = format.parse(yearMonth);
            endDate = getMonthEnd(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endDate;
    }

    public static String getYearMonth(Date date) {
        String yearMonth = "";
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.DATETIME_PATTERN_YEARMONTH);
        yearMonth = format.format(date);
        return yearMonth;
    }

    public static String getStartDateByPeriodType(Integer periodId) {
        if (periodId == null || periodId == 0) {
            periodId = new Integer(ConstantCfg.PERIOD_TYPE_LAST_WEEK);
        }
        Date date = new Date();
        SimpleDateFormat simdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String result = "";
        if (periodId != null) {
            switch (periodId) {
                case ConstantCfg.PERIOD_TYPE_CURRENT_WEEK:
                    int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
                    if (1 == dayWeek) {
                        cal.add(Calendar.DAY_OF_MONTH, -1);
                    }
                    cal.set(cal.DAY_OF_WEEK, cal.MONDAY);
                    result = simdf.format(cal.getTime());
                    break;
                case ConstantCfg.PERIOD_TYPE_CURRENT_MONTH:
                    cal.set(Calendar.DAY_OF_MONTH, 1);
                    result = simdf.format(cal.getTime());
                    break;
                case ConstantCfg.PERIOD_TYPE_LAST_WEEK:
                    cal.add(Calendar.WEEK_OF_MONTH, -1);
                    cal.set(Calendar.DAY_OF_WEEK, 1);
                    cal.add(Calendar.DATE, 1);
                    result = simdf.format(cal.getTime());
                    break;
                case ConstantCfg.PERIOD_TYPE_LAST_MONTH:
                    cal.add(Calendar.MONTH, -1);
                    cal.set(Calendar.DAY_OF_MONTH, 1);
                    result = simdf.format(cal.getTime());
                    break;
                case ConstantCfg.PERIOD_TYPE_THREE_MONTHS:
                    cal.add(Calendar.MONTH, -3);
                    cal.set(Calendar.DAY_OF_MONTH, 1);
                    result = simdf.format(cal.getTime());
                    break;
                case ConstantCfg.PERIOD_TYPE_HALF_YEAR:
                    cal.add(Calendar.MONTH, -6);
                    cal.set(Calendar.DAY_OF_MONTH, 1);
                    result = simdf.format(cal.getTime());
                    break;
                case ConstantCfg.PERIOD_TYPE_ONE_YEAR:
                    cal.add(Calendar.MONTH, -12);
                    cal.set(Calendar.DAY_OF_MONTH, 1);
                    result = simdf.format(cal.getTime());
                    break;
                case ConstantCfg.PERIOD_TYPE_LAST_YEAR:
                    cal.add(Calendar.YEAR, -1);
                    cal.set(Calendar.DAY_OF_YEAR, 1);
                    result = simdf.format(cal.getTime());
                    break;
            }
        }
        return result;
    }

    public static String getEndDateByPeriodType(Integer periodId) {
        if (periodId == null) {
            periodId = new Integer(ConstantCfg.PERIOD_TYPE_THREE_MONTHS);
        }
        Date date = new Date();
        SimpleDateFormat simdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String result = "";
        if (periodId != null) {
            switch (periodId) {
                case ConstantCfg.PERIOD_TYPE_CURRENT_WEEK:
                    result = simdf.format(date);
                    break;
                case ConstantCfg.PERIOD_TYPE_CURRENT_MONTH:
                    result = simdf.format(date);
                    break;
                case ConstantCfg.PERIOD_TYPE_LAST_WEEK:
                    cal.add(Calendar.WEEK_OF_MONTH, -1);
                    cal.set(Calendar.DAY_OF_WEEK, 1);
                    cal.add(Calendar.DATE, 7);
                    result = simdf.format(cal.getTime());
                    break;
                case ConstantCfg.PERIOD_TYPE_LAST_MONTH:
                    cal.set(Calendar.DAY_OF_MONTH, 0);//设置为1号,当前日期既为本月第一天
                    result = simdf.format(cal.getTime());
                    break;
                case ConstantCfg.PERIOD_TYPE_THREE_MONTHS:
                    result = simdf.format(date);
                    break;
                case ConstantCfg.PERIOD_TYPE_HALF_YEAR:
                    result = simdf.format(date);
                    break;
                case ConstantCfg.PERIOD_TYPE_ONE_YEAR:
                    result = simdf.format(date);
                    break;
                case ConstantCfg.PERIOD_TYPE_LAST_YEAR:
                    cal.add(Calendar.YEAR, -1);
                    cal.set(Calendar.DAY_OF_YEAR, 1);
                    cal.roll(Calendar.DAY_OF_YEAR, -1);
                    result = simdf.format(cal.getTime());
                    break;
            }
        }
        return result;
    }

    public static List<String> getWorkDateList(Date sd, Date ed) throws Exception {
        if (sd.after(ed)) {
            throw new AppException("开始时间不能大于结束时间");
        }
        List<String> datesStr = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sd);
        while (calendar.getTime().before(ed)) {
            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                datesStr.add(sdf.format(calendar.getTime()));
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        return datesStr;
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(getEndDateByPeriodType(1));
//        System.out.println(getEndDateByPeriodType(2));
//        System.out.println(getEndDateByPeriodType(3));
//        System.out.println(getEndDateByPeriodType(4));
//        System.out.println(getEndDateByPeriodType(5));
//        System.out.println(getEndDateByPeriodType(6));
//        System.out.println(getEndDateByPeriodType(7));
//        System.out.println(getEndDateByPeriodType(8));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(getWorkDateList(sdf.parse("2019-03-01"), new Date()).toString());

    }


}
