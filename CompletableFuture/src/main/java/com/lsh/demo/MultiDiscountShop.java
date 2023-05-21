package com.lsh.demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @Author lishaohui
 * @Date 2023/5/21 22:02
 */
public class MultiDiscountShop {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    // 多个shop的情况
    static List<Shop> shopList = Arrays.asList(
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll")
    );

    public List<String> findPrices(String product) {
        return shopList
                .stream()
                .map(shop -> shop.getStringPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscountIntoProduct)
                .collect(Collectors.toList());
    }

    public List<String> findPriceCompletableFuture(String product) {
        List<CompletableFuture<String>> priceFutures =
                shopList.stream()
                        // 以异步方式获取每个shop中指定商品的原始价格
                        .map(shop -> CompletableFuture.supplyAsync(
                                () -> shop.getStringPrice(product), executorService)
                            )
                        // 当Queue对象存在时，进行转化
                        .map(future -> future.thenApply(Quote::parse))
                        // 使用另一个异步任务构造期望的Future，申请折扣
                        .map(future -> future.thenCompose(quote ->
                                CompletableFuture.supplyAsync(() -> Discount.applyDiscountIntoProduct(quote), executorService))
                            )
                        .collect(Collectors.toList());
        // 等待流中的所有Future执行完毕，并提取出各自的返回值
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

}
