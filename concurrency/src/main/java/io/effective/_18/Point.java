package io.effective._18;

import java.util.concurrent.locks.StampedLock;

/**
 * @author luxz
 * @date 2020/6/27-3:31 AM
 * 如果执行乐观读操作期间，存在写操作，会把乐观读升级为悲观读锁
 */
public class Point {
    private int x, y;
    final StampedLock sl = new StampedLock();

    int distanceFromOrigin() {
        // 乐观读
        long stamp = sl.tryOptimisticRead();
        // 读入局部变量，读入的过程中数据可能被修改
        int curX = x, curY = y;
        // 判断执行读操作期间，是否存在写操作，如果存在，则sl.validate返回false
        if (!sl.validate(stamp)) {
            // 升级为悲观读锁
            stamp = sl.readLock();
            try {
                curX = x;
                curY = y;
            } finally {
                // 释放悲观读锁
                sl.unlockRead(stamp);
            }
        }
        return (int) Math.sqrt(curX * curX + curY * curY);
    }
}
