package com.lsh.design.strategy;

/**
 * @Author lishaohui
 * @Date 2023/5/19 12:03
 */
public class IsAllLowCase implements ValidationStrategy<String> {

    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }

}
