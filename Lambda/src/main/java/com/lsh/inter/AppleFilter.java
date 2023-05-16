package com.lsh.inter;

import com.lsh.dmo.Apple;

/**
 * @Author lishaohui
 * @Date 2023/5/16 16:04
 */
@FunctionalInterface
public interface AppleFilter {

    boolean filter(Apple apple);

}
