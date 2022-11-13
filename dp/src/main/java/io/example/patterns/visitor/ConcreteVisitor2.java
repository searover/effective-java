package io.example.patterns.visitor;

/**
 * @author luxz
 * @date 2022/11/13-18:31
 */
public class ConcreteVisitor2 extends Visitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.printf("%s 被 %s 访问%n", concreteElementA.getClass().getSimpleName(), this.getClass().getSimpleName());
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.printf("%s 被 %s 访问%n", concreteElementB.getClass().getSimpleName(), this.getClass().getSimpleName());
    }
}
