package net.mindview.util;

public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    private final C third;

    public ThreeTuple(A first, B second, C c) {
        super(first, second);
        third = c;
    }

    public C getThird() {
        return third;
    }

    @Override
    public String toString() {
        return "ThreeTuple{" +
                "third=" + third +
                ", first=" + first +
                ", second=" + second +
                '}';
    }
}
