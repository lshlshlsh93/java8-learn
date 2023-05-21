package com.lsh.demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @Author lishaohui
 * @Date 2023/5/21 21:23
 */
public class ShopClient {

    public static void main(String[] args) {

        Shop shop = new Shop("my-shop");
        long startTime = System.nanoTime();
        Future<Double> shopPrice = shop.getPriceAsync("my favourite product");
        long invocationTime = ((System.nanoTime() - startTime) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        // 执行更多任务，比如查询其他商店
        // doSomethingElse();
        // 在计算商品价格的同时
        try {
            double price = shopPrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - startTime) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");


        // 多个shop的情况
        List<Shop> shopList = Arrays.asList(
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll")
        );
        // 传统stream方式
        long start = System.nanoTime();
        System.out.println(new MultiShop(shopList).findPrices("iPhone 14"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");

        // 使用并行流方式
        long parallelStart = System.nanoTime();
        System.out.println(new MultiShop(shopList).findPrices("iPhone 14 pro max"));
        long parallelDuration = (System.nanoTime() - parallelStart) / 1_000_000;
        System.out.println("Done in " + parallelDuration + " msecs");

    }

}
