package io.example.patterns.strategy;

/**
 * @author luxz
 * @date 2022/11/19-13:01
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        strategy.AlgorithmInterface();
    }
}
