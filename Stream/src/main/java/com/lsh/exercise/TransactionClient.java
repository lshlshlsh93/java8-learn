package com.lsh.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author lishaohui
 * @Date 2023/5/16 23:05
 */
public class TransactionClient {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        // 需求1：找出2011年发生的所有交易，并按交易额排序（从低到高）
        List<Transaction> transactionList = transactions
                .stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .peek(p -> System.out.println("filtered value : " + p))
                .sorted(Comparator.comparing(Transaction::getValue))
                .peek(p -> System.out.println("sorted value : " + p))
                .collect(Collectors.toList());
        // 需求2：交易员都在哪些不同的城市工作过？
        List<String> distinctCityList = transactions
                .stream()
                .map(transaction -> transaction.getTrader().getCity())
                .peek(p -> System.out.println("mapped value : " + p))
                .distinct()
                .collect(Collectors.toList());
        Set<String> distinctCitySet = transactions
                .stream()
                .map(transaction -> transaction.getTrader().getCity())
                .peek(p -> System.out.println("mapped value : " + p))
                .collect(Collectors.toSet());
        // 需求3：查找所有来自于剑桥的交易员，并按姓名排序。
        transactions
                .stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        // 需求4：返回所有交易员的姓名字符串，按字母顺序排序。
        String nameStr = transactions
                .stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        String traderStr = transactions
                .stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        // 需求5：有没有交易员是在米兰工作的？
        boolean hasWorkWithMilan = transactions
                .stream()
                .anyMatch(transaction ->transaction.getTrader().getCity().equals("Milan"));
        // 需求6：打印生活在剑桥的交易员的所有交易额。
        transactions
                .stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
        // 需求7：所有交易中，最高的交易额是多少？
        Optional<Integer> maxValue = transactions
                .stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        // 需求8：找到交易额最小的交易
        Optional<Transaction> minValueTraction = transactions
                .stream()
                .min(Comparator.comparing(Transaction::getValue));

    }

}
