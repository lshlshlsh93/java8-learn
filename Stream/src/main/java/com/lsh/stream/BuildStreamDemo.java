package com.lsh.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author lishaohui
 * @Date 2023/5/18 22:28
 */
public class BuildStreamDemo {

    public static void main(String[] args) {

        // 创建一个字符流
        Stream<String> stringStream = Stream.of("Java", "React", "Vue", "Html5", "Css3");
        stringStream.map(String::toUpperCase).forEach(s -> System.out.println("Value: " + s));

        // 创建一个空的字符流
        Stream<String> emptyStream = Stream.empty();

        // 通过数组方式创建流
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        IntStream numberStream = Arrays.stream(numbers);
        int numbersSum = numberStream.sum();
        System.out.println(numbersSum);


        // 通过文件方式创建流
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(
                Paths.get("D:\\Java Module\\Java8-Learn\\Stream\\src\\main\\java\\com\\lsh\\stream\\data.txt"),
                Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("uniqueWords: " + uniqueWords);


        // 通过函数创建无限流
        // iterate(final T seed, final UnaryOperator<T> f)
        // 第一个参数是初始值，第二个参数是产出新值的operator
        Stream.iterate(0, n -> n + 2).limit(10).forEach(v -> System.out.print("Value: " + v + " "));
        System.out.println();
        // 生成斐波那契数列
        System.out.print("Fib: ");
        Stream
                .iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(v -> System.out.print("" + v + " "));
        System.out.println();


        // generate(Supplier<? extends T> s)
        System.out.println("Random double value");
        Stream.generate(Math::random).limit(5).forEach(v -> System.out.print("" + v + " "));
        System.out.println();
    }

}
