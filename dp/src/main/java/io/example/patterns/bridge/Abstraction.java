package io.example.patterns.bridge;

/**
 * @author luxz
 * @date 2022/11/12-18:27
 */
public abstract class Abstraction {
    protected Implementor implementor;

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operation();
}
