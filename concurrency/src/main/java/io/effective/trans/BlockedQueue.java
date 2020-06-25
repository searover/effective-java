package io.effective.trans;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luxz
 * @date 2020/6/25-7:59 PM
 */
public class BlockedQueue<T> {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    private List<T> list = new ArrayList<>();
    private static final int LENGTH = 10;

    void enq(T x) {
        lock.lock();
        try {
            while (list.size() >= 10) { // 队列已潢
                notFull.await();
            }
        } catch (InterruptedException e) {

        } finally {
            // 入队后，可通知出队
            notEmpty.signal();
        }
        lock.unlock();
    }

    void deq() {
        lock.lock();
        try {
            while (list.isEmpty()) {
                notEmpty.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 出队后，可通知入队
            notFull.signal();
        }
        lock.unlock();
    }
}
