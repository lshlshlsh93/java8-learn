package com.lsh.datetime;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @Author lishaohui
 * @Date 2023/5/16 16:53
 */
public class LocalDateAPI {

    public static void main(String[] args) {

        // 通过静态工厂方法 of 创建一个 LocalDate 实例
        LocalDate localDate = LocalDate.of(2023, 5, 1);
        System.out.println("Date Instance: " + localDate);
        // 获取实例中的年份
        System.out.println("localDate.getYear() = " + localDate.getYear()); // 2023
        // 获取当前实例中的月份
        System.out.println("localDate.getMonth() = " + localDate.getMonth()); // MAY
        // 获取当前实例中的月份值
        System.out.println("localDate.getMonthValue() = " + localDate.getMonthValue()); // 5
        // 获取当前实例是当月中的第几天
        System.out.println("localDate.getDayOfMonth() = " + localDate.getDayOfMonth()); // 1
        // 获取当前实例是星期几
        System.out.println("localDate.getDayOfWeek() = " + localDate.getDayOfWeek()); // MONDAY
        // 获取当前实例是当年中的第几天
        System.out.println("localDate.getDayOfYear() = " + localDate.getDayOfYear()); // 121
        // 获取当前实例中年份是否是闰年
        System.out.println("localDate.isLeapYear() = " + localDate.isLeapYear()); // false
        System.out.println("--------------------------------------------");

        // 通过工厂方法从系统时钟中获取当前的日期
        LocalDate localDateNow = LocalDate.now();
        System.out.println("Now Instance: " + localDateNow);
        // 通过ChronoField 枚举枚举获取日期信息
        System.out.println("localDateNow.get(ChronoField.YEAR) = " + localDateNow.get(ChronoField.YEAR));
        System.out.println("localDateNow.get(ChronoField.MONTH_OF_YEAR) = " + localDateNow.get(ChronoField.MONTH_OF_YEAR));
        System.out.println("localDateNow.get(ChronoField.DAY_OF_MONTH) = " + localDateNow.get(ChronoField.DAY_OF_MONTH));
        System.out.println("--------------------------------------------");

        LocalDate parseLocalDate = LocalDate.parse("2023-10-01");
        System.out.println("parseLocalDate.getYear() = " + parseLocalDate.getYear()); // 2023
        System.out.println("parseLocalDate.getMonthValue() = " + parseLocalDate.getMonthValue()); // 10
        System.out.println("parseLocalDate.getDayOfMonth() = " + parseLocalDate.getDayOfMonth()); // 1
        System.out.println("--------------------------------------------");


        LocalDate oldLocalDate = LocalDate.parse("2023-05-10");
        LocalDate newLocalDate = LocalDate.parse("2023-05-15");
        System.out.printf("Old Instance: %s\nNew Instance: %s\n", oldLocalDate, newLocalDate);
        // 判断当前日期实例是否晚于给定实例
        System.out.println("oldLocalDate.isAfter(newLocalDate) = " + oldLocalDate.isAfter(newLocalDate)); // false
        // 判断当前日期实例是否相等于给定实例
        System.out.println("oldLocalDate.isEqual(newLocalDate) = " + oldLocalDate.isEqual(newLocalDate)); // false
        // 判断当前日期实例是否早于给定实例
        System.out.println("oldLocalDate.isBefore(newLocalDate) = " + oldLocalDate.isBefore(newLocalDate)); // true
        System.out.println("--------------------------------------------");


        LocalDate currentLocalDate = LocalDate.parse("2020-12-25");
        System.out.println("currentLocalDate Instance: " + currentLocalDate); // 2020-12-25
        // 修改年份
        System.out.println("currentLocalDate.withYear(2023) = " + currentLocalDate.withYear(2023)); // 2023-12-25
        // 修改一年中的月份
        System.out.println("currentLocalDate.withMonth(10) = " + currentLocalDate.withMonth(10)); // 2020-10-25
        System.out.println("with(ChronoField.MONTH_OF_YEAR,5) = " + currentLocalDate.with(ChronoField.MONTH_OF_YEAR,5)); // 2020-05-25
        // 修改某月中所在的天数
        System.out.println("currentLocalDate.withYear(31) = " + currentLocalDate.withDayOfMonth(31)); // 2020-12-31
        System.out.println("--------------------------------------------");

        LocalDate luckLocalDate = LocalDate.parse("2025-12-17");
        System.out.println("luckLocalDate Instance: " + luckLocalDate); // 2025-12-17
        // 在当前日期实例加上一周
        System.out.println("luckLocalDate.plusWeeks(1) = " + luckLocalDate.plusWeeks(1)); // 2025-12-24
        // 在当前日期实例上减去5年
        System.out.println("luckLocalDate.plusWeeks(1) = " + luckLocalDate.minusYears(5)); // 2020-12-17
        // 在当前日期实例上减去2月
        System.out.println("luckLocalDate.plusWeeks(1) = " + luckLocalDate.minus(2, ChronoUnit.MONTHS)); // 2020-10-17


    }

}
