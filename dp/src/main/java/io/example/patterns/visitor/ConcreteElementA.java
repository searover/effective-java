package io.example.patterns.visitor;

/**
 * @author luxz
 * @date 2022/11/13-18:32
 */
public class ConcreteElementA extends Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);
    }

    public void operationA() {
    }
}
