package io.example.patterns.visitor;

/**
 * @author luxz
 * @date 2022/11/13-18:38
 */
public class Main {
    public static void main(String[] args) {
        ObjectStructure o = new ObjectStructure();
        Element ea = new ConcreteElementA();
        Element eb = new ConcreteElementB();
        Visitor v1 = new ConcreteVisitor1();
        Visitor v2 = new ConcreteVisitor2();
        o.attach(ea);
        o.attach(eb);
        o.accept(v1);
        o.accept(v2);
    }
}
