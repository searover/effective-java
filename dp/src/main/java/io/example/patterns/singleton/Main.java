package io.example.patterns.singleton;

/**
 * @author luxz
 * @date 2022/11/12-16:32
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
    }
}
