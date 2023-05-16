import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author lishaohui
 * @Date 2023/5/16 16:28
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 筛选
        integerList.stream().filter(integer -> integer > 2).collect(Collectors.toList());
        System.out.println("\n===============================");
        List<Integer> integer1 = Arrays.asList(1, 2, 3, 2, 5, 6, 6, 8);
        // 筛选并去重
        integer1.stream().filter(i -> i % 2 == 0).distinct().forEachOrdered(System.out::print);
        System.out.println("\n===============================");
        // 筛选、去重、截断流
        integer1.stream().filter(i -> i % 2 == 0).distinct().limit(2).forEachOrdered(System.out::print);
        System.out.println("\n===============================");
        // skip(n)跳过元素，返回一个扔掉了前n个元素的流
        integer1.stream().filter(i -> i % 2 == 0).distinct().skip(2).forEachOrdered(System.out::print);
        System.out.println("\n===============================");
        // 对流中每一个元素进行映射
        List<String> nameList = Arrays.asList("lucy", "tom", "Lucy");
        nameList.stream().map(String::length).collect(Collectors.toList()).forEach((System.out::print));
        System.out.println("\n===============================");
        // 流的扁平化
        nameList.stream().map(name->name.split(" ")).distinct().collect(Collectors.toList()).forEach((System.out::print));


    }

}
