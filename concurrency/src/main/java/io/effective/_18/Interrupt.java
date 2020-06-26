package io.effective._18;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

/**
 * @author luxz
 * @date 2020/6/27-3:46 AM
 */
public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        final StampedLock lock = new StampedLock();
        Thread t1 = new Thread(() -> {
            // 获取写锁
            lock.writeLock();
            // 永远阻塞在这里，不释放写锁
            LockSupport.park();
            ;
        });
//        t1.start();
        Thread.sleep(100);
        Thread t2 = new Thread(() -> {
            try {
                lock.readLockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        Thread.sleep(100);
        // 中断线程t2，会导致cpu飙升
        t2.interrupt();
        t2.join();
    }
}
