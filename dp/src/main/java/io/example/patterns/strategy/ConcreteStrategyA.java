package io.example.patterns.strategy;

/**
 * @author luxz
 * @date 2022/11/19-13:00
 */
public class ConcreteStrategyA extends Strategy {
    @Override
    public void AlgorithmInterface() {
        System.out.println("算法 A 实现");
    }
}
