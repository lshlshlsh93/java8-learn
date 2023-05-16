package com.lsh.logic;

import com.lsh.dmo.Apple;
import com.lsh.inter.AppleFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lishaohui
 * @Date 2023/5/16 15:39
 */
public class FilterAppleByColorTraditional {

    public static final String GREEN_COLOR = "green";

    public static class FilterAppleByColorAndWeightTraditional implements AppleFilter {

        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals(GREEN_COLOR) && apple.getWeight() >= 150);
        }
    }


    public static List<Apple> filterGreenApplesTraditional(List<Apple> inventory) {
        // 传统方式
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (GREEN_COLOR.equals(apple.getColor()))
                result.add(apple);
        }
        return result;
    }

    public static List<Apple> filterGreenApplesTraditionalWithColorAndWeight(
            List<Apple> inventory,
            AppleFilter appleFilter) {
        // 传统方式
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (appleFilter.filter(apple))
                result.add(apple);
        }
        return result;
    }

    public static List<Apple> filterGreenApplesTraditionalWithColor(List<Apple> inventory, String color) {
        // 传统方式
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor()))
                result.add(apple);
        }
        return result;
    }


    public static List<Apple> buildAppleInventory() {
        return Arrays.asList(
                new Apple("红富士", "red", 100),
                new Apple("红将军", "green", 150),
                new Apple("红星", "yellow", 50),
                new Apple("蛇果", "white", 200)
        );
    }

    public static void main(String[] args) {
        List<Apple> inventory = buildAppleInventory();
        List<Apple> filterGreenApples = filterGreenApplesTraditional(inventory);
        List<Apple> filterGreenApplesWithColor = filterGreenApplesTraditionalWithColor(inventory, GREEN_COLOR);
        List<Apple> filterGreenApplesWithColorAndWeight =
                filterGreenApplesTraditionalWithColorAndWeight(inventory, new FilterAppleByColorAndWeightTraditional());
        System.out.println(filterGreenApples);
        System.out.println(filterGreenApplesWithColor);
        System.out.println(filterGreenApplesWithColorAndWeight);
    }
}
