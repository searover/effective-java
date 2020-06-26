package io.effective._19;

import java.util.Vector;
import java.util.concurrent.*;

/**
 * @author luxz
 * @date 2020/6/27-5:03 AM
 */
public class OrderService {

    private Vector<Integer> pOrders;
    private Vector<Integer> dOrders;

    private Vector<Integer> getPOrders() {
        System.out.println("get p orders...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Vector<>();
    }

    private Vector<Integer> getDOrders() {
        System.out.println("get d orders...");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Vector<>();
    }

    private void check(Integer o1, Integer o2) {
        System.out.println("check orders...");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void saveDiff() {
        System.out.println("save differences...");
    }

    private void checkWithThreadJoin() throws InterruptedException {
        while (true) {
            Thread t1 = new Thread(() -> {
                pOrders = getPOrders();
            });
            t1.start();
            Thread t2 = new Thread(() -> {
                dOrders = getDOrders();
            });
            t2.start();

            t1.join();
            t2.join();

            check(pOrders.remove(0), dOrders.remove(0));
            saveDiff();
        }
    }

    private void checkWithThreadPool() throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(2);
        while (true) {
            executor.execute(() -> {
                pOrders = getPOrders();
                latch.countDown();
            });
            executor.execute(() -> {
                dOrders = getDOrders();
                latch.countDown();
            });
            latch.await();
            check(pOrders.remove(0), dOrders.remove(0));
            saveDiff();
        }
    }

    private void checkWithCyclicBarrier() {
        Vector<Integer> pos = new Vector<>();
        Vector<Integer> dos = new Vector<>();
        Executor executor = Executors.newFixedThreadPool(2);
        final CyclicBarrier barrier = new CyclicBarrier(2, () -> executor.execute(() -> {
            check(pos.remove(0), dos.remove(0));
        }));
        Thread t1 = new Thread(() -> {
            while (true) {
                pos.addAll(getPOrders());
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            while (true) {
                dos.addAll(getDOrders());
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }

}
