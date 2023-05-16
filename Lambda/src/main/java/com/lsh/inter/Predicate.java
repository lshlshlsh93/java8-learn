package com.lsh.inter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lishaohui
 * @Date 2023/5/16 16:12
 */
public interface Predicate<T> {

    boolean filter(T t);

    static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.filter(t)) {
                result.add(t);
            }
        }
        return result;
    }

}
