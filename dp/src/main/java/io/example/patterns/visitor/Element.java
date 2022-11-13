package io.example.patterns.visitor;

/**
 * @author luxz
 * @date 2022/11/13-18:31
 */
public abstract class Element {
    public abstract void accept(Visitor visitor);
}
