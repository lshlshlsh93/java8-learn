package com.lsh.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

/**
 * @Author lishaohui
 * @Date 2023/5/16 18:45
 */
public class DateTimeFormatterAPI {

    public static void main(String[] args) {

        LocalDateTime nowLocalDateTime = LocalDateTime.now();
        System.out.println("nowLocalDateTime Instance: " + nowLocalDateTime); // 2023-05-16T18:50:02.944115900
        System.out.println("--------------------------------------------");

        System.out.println("nowLocalDateTime.format(DateTimeFormatter.BASIC_ISO_DATE) = "
                + nowLocalDateTime.format(DateTimeFormatter.BASIC_ISO_DATE)); // 20230516
        System.out.println("nowLocalDateTime.format(DateTimeFormatter.ISO_DATE) = "
                + nowLocalDateTime.format(DateTimeFormatter.ISO_DATE)); // 2023-05-16
        System.out.println("nowLocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE) = "
                + nowLocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE)); // 2023-05-16
        System.out.println("nowLocalDateTime.format(DateTimeFormatter.ISO_TIME) = "
                + nowLocalDateTime.format(DateTimeFormatter.ISO_TIME)); // 18:50:02.9441159
        System.out.println("nowLocalDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME) = "
                + nowLocalDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME)); // 18:50:02.9441159
        System.out.println("nowLocalDateTime.format(DateTimeFormatter.ISO_DATE_TIME) = "
                + nowLocalDateTime.format(DateTimeFormatter.ISO_DATE_TIME)); // 2023-05-16T18:50:02.9441159
        System.out.println("nowLocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) = "
                + nowLocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // 2023-05-16T18:50:02.9441159
        System.out.println("--------------------------------------------");


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentLocalDateTime = LocalDateTime.now();
        System.out.println("currentLocalDateTime Instance: " + currentLocalDateTime); // 2023-05-16T18:57:25.688524200
        System.out.println("currentLocalDateTime.format(dateTimeFormatter) = " + currentLocalDateTime.format(dateTimeFormatter)); // 2023-05-16 18:57:25
        System.out.println("--------------------------------------------");

        // 自定义DateTimeFormatter
        DateTimeFormatter customChinaFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.YEAR)
                .appendLiteral("年 ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral("日 ")
                .parseCaseInsensitive()
                .toFormatter(Locale.CHINA);
        LocalDateTime myLocalDateTime = LocalDateTime.now();
        System.out.println("myLocalDateTime Instance: " + myLocalDateTime); // 2023-05-16T18:57:25.688524200
        System.out.println("currentLocalDateTime.format(dateTimeFormatter) = " + currentLocalDateTime.format(customChinaFormatter)); // 2023年 五月 16日
        System.out.println("--------------------------------------------");
    }

}
