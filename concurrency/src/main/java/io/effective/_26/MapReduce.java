package io.effective._26;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author luxz
 * @date 2020/7/5-1:47 AM
 */
public class MapReduce {
    static class Fibo extends RecursiveTask<Integer> {
        final int n;

        Fibo(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n <= 1) {
                return n;
            }
            Fibo f1 = new Fibo(n - 1);
            f1.fork();
            Fibo f2 = new Fibo(n - 2);
            int result = f2.compute() + f1.join();
            System.out.println(Thread.currentThread() + "\t" + result);
            return result;
        }
    }

    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool(32);
        Fibo fib = new Fibo(45);
        int result = fjp.invoke(fib);
        System.out.println(result);
    }
}
