package io.example.patterns.mediator;

/**
 * @author luxz
 * @date 2022/11/13-13:22
 */
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
