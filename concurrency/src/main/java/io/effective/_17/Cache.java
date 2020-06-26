package io.effective._17;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author luxz
 * @date 2020/6/26-5:07 PM
 */
public class Cache<K, V> {
    final Map<K, V> m = new HashMap<>();
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    // read lock
    final Lock r = rwl.readLock();
    // write lock
    final Lock w = rwl.writeLock();

    // read cache
    V get(K key) {
        V v = null;
        r.lock();
        try {
            v = m.get(key);
            if (v == null) {
                // 读锁升级写锁，会导致阻塞
                w.lock();
                try {
                    // recheck, other threads may query database already
                    v = m.get(key);
                    if (v == null) {
                        // query database
                        m.put(key, v);
                    }
                } finally {
                    w.unlock();
                }
            }
        } finally {
            r.unlock();
        }
        return v;
    }

    // write cache
    V put(K key, V value) {
        w.lock();
        try {
            return m.put(key, value);
        } finally {
            w.unlock();
        }
    }

    public static void main(String[] args) {
        System.out.println("Program start...");
        Cache<String, String> cache = new Cache<>();
        cache.put("hello", "world");
        System.out.println(cache.get("hell"));
        System.out.println("Program end...");
    }
}
