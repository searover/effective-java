package io.example.patterns.flyweight;

/**
 * @author luxz
 * @date 2022/11/13-16:47
 */
public class ConcreteFlyweight extends Flyweight {
    @Override
    public void operation(int extrinsicstate) {
        System.out.println("具体 Flyweight: " + extrinsicstate);
    }
}
