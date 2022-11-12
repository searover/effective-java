package io.example.patterns.iterator;

/**
 * @author luxz
 * @date 2022/11/12 14:09
 */
public interface Iterator {
    Object first();

    Object next();

    boolean isDone();

    Object current();
}
