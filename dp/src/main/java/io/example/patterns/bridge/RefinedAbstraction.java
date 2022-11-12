package io.example.patterns.bridge;

/**
 * @author luxz
 * @date 2022/11/12-18:27
 */
public class RefinedAbstraction extends Abstraction {
    @Override
    public void operation() {
        implementor.operation();
        ;
    }
}
