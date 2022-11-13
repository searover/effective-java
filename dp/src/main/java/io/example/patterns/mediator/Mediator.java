package io.example.patterns.mediator;

/**
 * @author luxz
 * @date 2022/11/13-13:20
 */
public abstract class Mediator {
    public abstract void Send(String message, Colleague colleague);
}
