package com.lsh.demo;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * @Author lishaohui
 * @Date 2023/5/21 21:32
 */
public class MultiShop {

    private final List<Shop> shopList;

    public MultiShop(List<Shop> shopList) {
        this.shopList = shopList;
    }

    public List<String> findPrices(String product) {
        return shopList.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getProduct(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public List<String> findPriceParallel(String product) {
        return shopList
                .parallelStream() // 采用并行流的方式
                .map(shop -> String.format("%s price is %.2f", shop.getProduct(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public List<String> findPriceCompletableFuture(String product) {
        List<CompletableFuture<String>> completableFutureProductList =
                shopList.stream()
                        .map(shop -> CompletableFuture.supplyAsync(() -> shop.getProduct() + " price is :" + shop.getPrice(product)))
                        .collect(Collectors.toList());
        return completableFutureProductList.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }


}
