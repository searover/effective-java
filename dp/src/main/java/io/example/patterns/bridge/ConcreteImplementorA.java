package io.example.patterns.bridge;

/**
 * @author luxz
 * @date 2022/11/12-18:26
 */
public class ConcreteImplementorA implements Implementor {
    @Override
    public void operation() {
        System.out.println("Concrete implementation A.");
    }
}
