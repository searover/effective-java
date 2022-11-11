package io.example.patterns.adapter;

/**
 * @author luxz
 * @date 2022/11/12-05:51
 */
public class Main {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.Request();
        System.out.printf("hello %s%n", "world");
    }
}
