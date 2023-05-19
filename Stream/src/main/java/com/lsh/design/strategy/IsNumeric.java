package com.lsh.design.strategy;

/**
 * @Author lishaohui
 * @Date 2023/5/19 12:04
 */
public class IsNumeric implements ValidationStrategy<String> {

    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
