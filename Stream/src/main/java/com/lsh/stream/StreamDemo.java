package com.lsh.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author lishaohui
 * @Date 2023/5/16 16:28
 */
public class StreamDemo {

    public static void main(String[] args) {

        // 通过数组方式构建流
        int[] arr = {1, 2, 3, 4, 5, 6, 8, 7, 8, 9, 10};
        IntStream integerList = Arrays.stream(arr);
        // 筛选
        integerList.filter(integer -> integer % 2 == 0).forEach(v -> System.out.println("偶数: " + v));
        System.out.println("\n===============================");

        List<Integer> integer1 = Arrays.asList(1, 2, 3, 2, 5, 6, 6, 8);
        // 筛选并去重
        integer1
                .stream()
                .filter(i -> i % 2 == 0).distinct().forEachOrdered(v -> System.out.print("Value: " + v));
        System.out.println("\n===============================");


        // 筛选、去重、截断流
        integer1
                .stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .limit(2)
                .forEachOrdered(System.out::print);
        System.out.println("\n===============================");

        // skip(n)跳过元素，返回一个扔掉了前n个元素的流
        integer1
                .stream()
                .skip(2)
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEachOrdered(System.out::print);
        System.out.println("\n===============================");

        // 对流中每一个元素进行映射
        List<String> nameList = Arrays.asList("lucy", "tom", "Lucy");
        nameList
                .stream()
                .map(String::length)
                .collect(Collectors.toList())
                .forEach(v -> System.out.print(v + " "));
        System.out.println("\n===============================");

        // 流的扁平化
        nameList
                .stream()
                .map(name -> name.split(" "))
                .distinct().collect(Collectors.toList())
                .forEach(v -> System.out.print(v[0] + " "));


        String[] arrayWords = {"Google", "Guava"};
        Stream<String> streamWords = Arrays.stream(arrayWords);
        List<String> stringList = streamWords
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> mulList =
                numbers
                        .stream()
                        .map(n -> n * n)
                        .collect(Collectors.toList());


        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = // [(2, 4), (3, 3)]
                numbers1.stream()
                        .flatMap(i ->
                                numbers2.stream()
                                        .filter(j -> (i + j) % 3 == 0)
                                        .map(j -> new int[]{i, j})
                        ).collect(Collectors.toList());


        // 规约
        // 求和
        List<Integer> nums = Arrays.asList(1, 2, 3);
        Integer sumInteger = nums
                .stream()
                .reduce(0, Integer::sum);
        int sumInt = nums.stream().mapToInt(n -> n).reduce(0, Integer::sum);
        Optional<Integer> sumResultInteger = nums.stream().reduce(Integer::sum);
        sumResultInteger.ifPresent(System.out::println);
        // 最大值
        Optional<Integer> maxResult = nums.stream().reduce(Integer::max);
        maxResult.ifPresent(System.out::println);
        // 最小值
        Optional<Integer> minResult = nums
                .stream()
                .reduce(Integer::min);
        minResult.ifPresent(System.out::println);
        // 计算个数
        long count = nums.stream().count();


        int sum = IntStream.range(1, 50).sum();// 不包含结尾值
        int sum2 = IntStream.rangeClosed(1, 50).sum(); // 包含结尾值

    }

}
