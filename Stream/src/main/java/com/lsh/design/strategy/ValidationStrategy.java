package com.lsh.design.strategy;

/**
 * @Author lishaohui
 * @Date 2023/5/19 12:02
 */
public interface ValidationStrategy<T> {

    boolean execute(T t);

}
