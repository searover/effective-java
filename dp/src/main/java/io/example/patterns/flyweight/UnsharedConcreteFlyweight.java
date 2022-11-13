package io.example.patterns.flyweight;

/**
 * @author luxz
 * @date 2022/11/13-16:49
 */
public class UnsharedConcreteFlyweight extends Flyweight {
    @Override
    public void operation(int extrinsicstate) {
        System.out.println("不共享的 Flyweight: " + extrinsicstate);
    }
}
