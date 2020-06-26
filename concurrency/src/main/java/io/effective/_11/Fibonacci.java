package io.effective._11;

import java.util.concurrent.locks.StampedLock;

/**
 * @author luxz
 * @date 2020/6/26-5:49 AM
 */
public class Fibonacci {

    public static int fibonacci(int x) {
        if (x <= 2) {
            return x;
        }

        return fibonacci(x - 1) + fibonacci(x - 2);
    }

    public static void main(String[] args) {
        StampedLock lock = new StampedLock();
        lock.asReadLock().lock();
        lock.asReadWriteLock().writeLock().lock();
    }
}
