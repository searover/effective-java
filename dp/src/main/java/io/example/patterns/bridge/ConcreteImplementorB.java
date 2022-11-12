package io.example.patterns.bridge;

/**
 * @author luxz
 * @date 2022/11/12-18:26
 */
public class ConcreteImplementorB implements Implementor {
    @Override
    public void operation() {
        System.out.println("Concrete implementation B.");
    }
}
