package io.example.patterns.visitor.cases;

/**
 * @author luxz
 * @date 2022/11/13-18:41
 */
public abstract class Person {
    public abstract void accept(Action action);
}
