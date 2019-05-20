package net.mindview.generics;

import net.mindview.util.Generator;

public class Fibonacci implements Generator<Integer> {
    private int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            System.out.println(gen.next());
        }

        char[] arr = new char[10];
        for (char c : arr) {
            System.out.println("char c: " + (int) c);
        }
    }
}
