package io.effective._15;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DefaultFuture {
    private final Lock lock = new ReentrantLock();
    private final Condition done = lock.newCondition();
    private Object response;

    Object get(int timeout) throws InterruptedException, TimeoutException {
        long start = System.nanoTime();
        lock.lock();
        try {
            while (!isDone()) {
                done.await(timeout, TimeUnit.SECONDS);
                long cur = System.nanoTime();
                if (isDone() || cur - start > timeout) {
                    break;
                }
            }
        } finally {
            lock.unlock();
        }
        if (!isDone()) {
            throw new TimeoutException();
        }
        return new Object();
    }

    boolean isDone() {
        return response != null;
    }

    private void doReceived(Object res) {
        lock.lock();
        try {
            response = res;
            if (done != null) {
                done.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}
