package io.example.patterns.strategy;

/**
 * @author luxz
 * @date 2022/11/19-13:04
 */
public class Main {
    public static void main(String[] args) {
        Context ctx = new Context(new ConcreteStrategyA());
        ctx.contextInterface();
        ctx = new Context(new ConcreteStrategyB());
        ctx.contextInterface();
    }
}
