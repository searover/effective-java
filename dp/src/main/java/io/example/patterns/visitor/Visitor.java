package io.example.patterns.visitor;

/**
 * @author luxz
 * @date 2022/11/13-18:31
 */
public abstract class Visitor {
    public abstract void visitConcreteElementA(ConcreteElementA concreteElementA);

    public abstract void visitConcreteElementB(ConcreteElementB concreteElementB);
}
