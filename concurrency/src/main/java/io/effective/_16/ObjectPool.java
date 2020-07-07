package io.effective._16;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * @author luxz
 * @date 2020/6/26-2:28 PM
 */
public class ObjectPool<T, R> {
    final List<T> pool;
    // 用信号量实现限流器
    final Semaphore sem;

    ObjectPool(int size, T t) {
        pool = new ArrayList<T>() {
        };
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        sem = new Semaphore(size);
    }

    R exec(Function<T, R> func) throws InterruptedException {
        T t = null;
        sem.acquire();
        try {
            t = pool.remove(0);
            return func.apply(t);
        } finally {
            pool.add(t);
            sem.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(20);
        ObjectPool<Long, String> pool = new ObjectPool<>(3, 2L);
        for (int i = 0; i < 10; i++) {
            es.execute(() -> {
                try {
                    pool.exec(t -> {
                        System.out.println(Thread.currentThread());
                        try {
                            int rand = new Random().nextInt(10);
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return t.toString();
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        es.shutdown();

    }
}
