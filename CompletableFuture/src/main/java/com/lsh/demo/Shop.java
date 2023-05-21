package com.lsh.demo;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @Author lishaohui
 * @Date 2023/5/21 21:16
 */
public class Shop {

    private static final Random random = new Random(System.currentTimeMillis());

    private final String name;

    public Shop(String name) {
        this.name = name;
    }

    public String getProduct() {
        return name;
    }

    public Future<Double> getPriceSupplyAsync(String product) {
        // 通过工厂方法方式
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double calculatePrice = calculatePrice(product);
                futurePrice.complete(calculatePrice);
            } catch (Exception ex) {
                // 异常处理
                futurePrice.completeExceptionally(ex);
            }
        }).start();
        return futurePrice;
    }

    // 计算价格
    public double getPrice(String product) {
        return calculatePrice(product);
    }
    public String getStringPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[
                random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    private double calculatePrice(String product) {
        delay(1_000L);
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    // 延时
    private static void delay(final long miles) {
        try {
            Thread.sleep(miles);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
