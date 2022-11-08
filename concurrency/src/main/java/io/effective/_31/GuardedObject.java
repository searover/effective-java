package io.effective._31;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

public class GuardedObject<T> {
    // 受保护的对象
    T obj;
    final Lock lock = new ReentrantLock();
    final Condition done = lock.newCondition();
    final int timeout = 2;
    // 保存所有的GuardedObject
    final static Map<Object, GuardedObject> map = new ConcurrentHashMap<>();

    // 静态方法创建GuardedObject
    static <K> GuardedObject create(K key) {
        GuardedObject go = new GuardedObject();
        map.put(key, go);
        return go;
    }

    static <K, T> void fireEvent(K key, T obj) {
        GuardedObject go = map.get(key);
        if (go != null) {
            go.onChanged(obj);
        }
    }

    // 获取受保护对象
    T get(Predicate<T> p) throws InterruptedException {
        lock.lock();
        try {
            // MESA 管程推荐写法
            while (!p.test(obj)) {
                done.await(timeout, TimeUnit.SECONDS);
            }
        } finally {
            lock.unlock();
        }
        return obj;
    }

    // 事件通知方法
    void onChanged(T obj) {
        lock.lock();
        try {
            this.obj = obj;
            done.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
