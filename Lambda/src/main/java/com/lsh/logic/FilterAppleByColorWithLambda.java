package com.lsh.logic;

import com.lsh.dmo.Apple;
import com.lsh.inter.AppleFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lishaohui
 * @Date 2023/5/16 16:04
 */
public class FilterAppleByColorWithLambda {
    public static final String GREEN_COLOR = "green";

    public static List<Apple> buildAppleInventory() {
        return Arrays.asList(
                new Apple("红富士", "red", 100),
                new Apple("红将军", "green", 150),
                new Apple("红星", "yellow", 50),
                new Apple("蛇果", "white", 200)
        );
    }

    public static List<Apple> filterGreenApplesTraditionalWithLambda(
            List<Apple> inventory, AppleFilter appleFilter) {
        // 传统方式
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (appleFilter.filter(apple))
                result.add(apple);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> appleInventory = buildAppleInventory();

        List<Apple> appleList = filterGreenApplesTraditionalWithLambda(appleInventory, (apple) -> apple.getColor().equals(GREEN_COLOR));
        System.out.println(appleList);

    }

}
