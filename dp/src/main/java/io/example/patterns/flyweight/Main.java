package io.example.patterns.flyweight;

/**
 * @author luxz
 * @date 2022/11/13-16:54
 */
public class Main {
    public static void main(String[] args) {
        int extrinsicstate = 22;
        FlyweightFactory ff = new FlyweightFactory();
        Flyweight fx = ff.getFlyweight("X");
        fx.operation(--extrinsicstate);
        Flyweight fy = ff.getFlyweight("Y");
        fy.operation(--extrinsicstate);
        Flyweight fz = ff.getFlyweight("Z");
        fz.operation(--extrinsicstate);

        Flyweight fu = new UnsharedConcreteFlyweight();
        fu.operation(--extrinsicstate);
    }
}
