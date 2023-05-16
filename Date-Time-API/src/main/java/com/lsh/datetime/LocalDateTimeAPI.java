package com.lsh.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author lishaohui
 * @Date 2023/5/16 17:46
 */
public class LocalDateTimeAPI {

    public static void main(String[] args) {

        // 创建实例
        LocalDate localDate = LocalDate.parse("2023-10-03");
        LocalTime localTime = LocalTime.parse("20:38:45");
        LocalDateTime localDateTimeInstance = LocalDateTime.of(localDate, localTime);
        System.out.println("LocalDateTime Instance: " + localDateTimeInstance); // 2023-10-03T20:38:45
        LocalDateTime localDateTime = LocalDateTime.of(2023, 5, 25, 21, 13, 46);
        System.out.println("localDateTime : " + localDateTime); // 2023-05-25T21:13:46
        LocalDateTime parseLocalDateTime = LocalDateTime.parse("2023-10-15T22:38:45");
        System.out.println("parseLocalDateTime Instance: " + parseLocalDateTime); // 2023-10-15T22:38:45
        System.out.println("--------------------------------------------");

        LocalDateTime nowLocalDateTime = LocalDateTime.now();
        System.out.println("nowLocalDateTime Instance: " + nowLocalDateTime); // 2023-05-16T17:56:57.432961900
        System.out.println("nowLocalDateTime.toLocalDate() = " + nowLocalDateTime.toLocalDate()); // 2023-05-16
        System.out.println("nowLocalDateTime.toLocalTime() = " + nowLocalDateTime.toLocalTime()); // 17:58:35.140045700
        System.out.println("--------------------------------------------");



    }


}
