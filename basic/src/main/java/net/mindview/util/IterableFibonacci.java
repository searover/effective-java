package net.mindview.util;

import net.mindview.generics.Fibonacci;

import java.util.Iterator;

/**
 * @author searover
 * 通过继承，使用适配器模式，实现 Iterable 接口
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;

    public IterableFibonacci(int count) {
        n = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (Integer i : new IterableFibonacci(18)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
