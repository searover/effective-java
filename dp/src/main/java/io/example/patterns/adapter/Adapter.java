package io.example.patterns.adapter;

/**
 * @author luxz
 * @date 2022/11/12-05:48
 */
public class Adapter extends Target {
    private Adaptee adaptee = new Adaptee();

    @Override
    public void Request() {
        adaptee.SpecialRequest();
    }
}
