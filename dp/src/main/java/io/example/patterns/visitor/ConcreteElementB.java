package io.example.patterns.visitor;

/**
 * @author luxz
 * @date 2022/11/13-18:32
 */
public class ConcreteElementB extends Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementB(this);
    }

    public void operationB() {

    }
}
