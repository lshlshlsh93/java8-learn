package com.lsh.datetime;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

/**
 * @Author lishaohui
 * @Date 2023/5/16 17:32
 */
public class LocalTimeAPI {

    public static void main(String[] args) {

        LocalTime localTimeInstance = LocalTime.of(14, 59, 45);
        System.out.println("Time Instance:  " + localTimeInstance);
        // 获取当前时间实例对应的一天内的几点
        System.out.println("localTimeInstance.getHour() = " + localTimeInstance.getHour());// 14
        // 获取当前时间实例中对应的一小时内的分钟数
        System.out.println("localTimeInstance.getMinute() = " + localTimeInstance.getMinute());// 59
        // 获取当前时间实例中对应的一分钟内的秒数
        System.out.println("localTimeInstance.getSecond() = " + localTimeInstance.getSecond());// 45
        System.out.println("--------------------------------------------");

        // 采用ChronoField枚举方式
        // 获取当前时间实例对应的一天内的几点
        System.out.println("localTimeInstance.get(ChronoField.HOUR_OF_DAY) = " + localTimeInstance.get(ChronoField.HOUR_OF_DAY)); // 14
        // 获取当前时间实例中对应的一小时内的分钟数
        System.out.println("localTimeInstance.get(ChronoField.MINUTE_OF_HOUR) = " + localTimeInstance.get(ChronoField.MINUTE_OF_HOUR)); // 59
        // 获取当前时间实例中对应的一分钟内的秒数
        System.out.println("localTimeInstance.get(ChronoField.SECOND_OF_MINUTE) = " + localTimeInstance.get(ChronoField.SECOND_OF_MINUTE)); // 45
        System.out.println("--------------------------------------------");

        LocalTime nowLocalTime = LocalTime.now();
        System.out.println("Now Time Instance: " + nowLocalTime);
        System.out.println("--------------------------------------------");

        LocalTime parseLocalTime = LocalTime.parse("23:59:10");
        System.out.println("Parse Time Instance: " + parseLocalTime);
        System.out.println("--------------------------------------------");

        LocalTime oldLocalTime = LocalTime.parse("23:59:10");
        LocalTime newLocalTime = LocalTime.parse("23:59:59");
        System.out.printf("oldLocalTime Instance: %s\nnewLocalTime Instance: %s\n", oldLocalTime, newLocalTime);
        System.out.println("oldLocalTime.isBefore(newLocalTime) = " + oldLocalTime.isBefore(newLocalTime));  // true
        System.out.println("oldLocalTime.equals(newLocalTime) = " + oldLocalTime.equals(newLocalTime)); // false
        System.out.println("oldLocalTime.isAfter(newLocalTime) = " + oldLocalTime.isAfter(newLocalTime)); // false
        System.out.println("--------------------------------------------");



    }

}
