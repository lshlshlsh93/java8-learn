package com.lsh.intro;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author lishaohui
 * @Date 2023/5/21 21:10
 */
public class OldUseOfFuture {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Double> future = executorService
                .submit(() -> {
                    // doSome computation
                    return null;
                });
        // do something else
        try {
            future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            // 线程在等待过程中被打断
            e.printStackTrace();
        } catch (ExecutionException e) {
            // 计算时抛出异常
            e.printStackTrace();
        } catch (TimeoutException e) {
            // 在Future对象完成之前已经超时
            e.printStackTrace();
        }

    }

}
