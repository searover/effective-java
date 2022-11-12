package io.example.patterns.bridge;

/**
 * @author luxz
 * @date 2022/11/12-18:30
 */
public class Main {
    public static void main(String[] args) {
        Abstraction a = new RefinedAbstraction();
        a.setImplementor(new ConcreteImplementorA());
        a.operation();
        a.setImplementor(new ConcreteImplementorB());
        a.operation();
    }
}
