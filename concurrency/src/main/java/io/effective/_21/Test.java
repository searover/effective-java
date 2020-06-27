package io.effective._21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author luxz
 * @date 2020/6/27-10:55 AM
 */
public class Test {
    static AtomicLong count = new AtomicLong(0);

    static void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Thread t1 = new Thread(Test::add10K);
        Thread t2 = new Thread(Test::add10K);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count=" + count);

        FutureTask<Integer> futureTask = new FutureTask<>(() -> 1 + 3);
        Thread t = new Thread(futureTask);
        t.start();
        Integer result = futureTask.get();
        System.out.println("result=" + result);
    }
}
