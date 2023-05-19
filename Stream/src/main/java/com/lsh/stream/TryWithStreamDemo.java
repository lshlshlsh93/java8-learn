package com.lsh.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author lishaohui
 * @Date 2023/5/18 22:18
 */
public class TryWithStreamDemo {

    public static void main(String[] args) {
        buildTriples().limit(5).forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));
    }

    public static Stream<double[]> buildTriples() {
        return IntStream
                .rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream
                        .rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t-> t[2] % 1 == 0));
    }

}
