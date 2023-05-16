package com.lsh.datetime;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @Author lishaohui
 * @Date 2023/5/16 19:06
 */
public class PeriodAndDurationAPI {

    public static void main(String[] args) {

        Duration eightHours = Duration.ofHours(8L); // 8小时
        Duration fiveMinutes = Duration.ofMinutes(5L); // 5分钟
        Duration fiveteenSeconds = Duration.ofSeconds(50L); //50秒
        Duration threeMinutes = Duration.of(3L, ChronoUnit.MINUTES); // 3分钟

        Period sixDays = Period.ofDays(6); // 6天
        Period sevenWeeks = Period.ofWeeks(7); // 7周
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1); // 两年六个月零一天
    }

}
