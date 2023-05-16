package com.lsh.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @Author lishaohui
 * @Date 2023/5/16 18:16
 */
public class TemporalAdjustersAPI {

    public static void main(String[] args) {

        LocalDate nowLocalDate = LocalDate.now();
        System.out.println("Date Instance:  " + nowLocalDate); // 2023-05-16
        LocalDate nextOrSameLocalDate = nowLocalDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)); // 2023-05-21
        System.out.println("nowLocalDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)) = " + nextOrSameLocalDate);
        System.out.println("--------------------------------------------");

        // lastDayOfMonth 当月的最后一天
        LocalDate lastDayOfMonthLocalDate = nowLocalDate.with(TemporalAdjusters.lastDayOfMonth()); // 2023-05-31
        System.out.println("nowLocalDate.with(TemporalAdjusters.lastDayOfMonth()) = " + lastDayOfMonthLocalDate);
        System.out.println("--------------------------------------------");

        // lastDayOfYear 今年的最后一天
        LocalDate lastDayOfYearLocalDate = nowLocalDate.with(TemporalAdjusters.lastDayOfYear()); // 2023-12-31
        System.out.println("nowLocalDate.with(TemporalAdjusters.lastDayOfYear()) = " + lastDayOfYearLocalDate);
        System.out.println("--------------------------------------------");

        // firstDayOfNextYear 明年的第一天
        LocalDate firstDayOfNextYearLocalDate = nowLocalDate.with(TemporalAdjusters.firstDayOfNextYear()); // 2024-01-01
        System.out.println("nowLocalDate.with(TemporalAdjusters.firstDayOfNextYear()) = " + firstDayOfNextYearLocalDate);
        System.out.println("--------------------------------------------");

        // firstDayOfMonth 当月的第一天
        LocalDate firstDayOfMonthLocalDate = nowLocalDate.with(TemporalAdjusters.firstDayOfMonth()); // 2023-05-01
        System.out.println("nowLocalDate.with(TemporalAdjusters.firstDayOfMonth()) = " + firstDayOfMonthLocalDate);

    }

}
