package io.effective;

import java.util.List;

/**
 * @author luxz
 * @date 2020/6/25-4:44 PM
 */
public class Allocator {
    private List<Object> als;

    // 一次性申请所有资源
    synchronized void apply(Object from, Object to) throws InterruptedException {
        //经典写法
        while (als.contains(from) || als.contains(to)) {
            wait();
        }
        als.add(from);
        als.add(to);
    }

    synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
        notifyAll();
    }
}
