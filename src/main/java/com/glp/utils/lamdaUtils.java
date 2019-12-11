package com.glp.utils;

import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author zmm
 * @date 2019/12/11
 */
@Component
public class lamdaUtils<T extends Object> {

    public void Action(Consumer<T> consumer, T t) {
        consumer.accept(t);

    }

    public T func(Supplier<T> suppier, T t) {
        return suppier.get();
    }
}
