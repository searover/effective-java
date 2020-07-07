package io.effective._16;

import java.util.Queue;

/**
 * @author luxz
 * @date 2020/6/26-2:11 PM
 */
public class MySemaphore {
    // 计数器
    int count;
    // 等待队列
    Queue queue;
    // 初始化操作

    public MySemaphore(int count) {
        this.count = count;
    }

    void down() {
        this.count--;
        if (this.count < 0) {
            // 将当前线程插入等待队列
            // 阻塞当前线程
        }
    }

    void up() {
        this.count++;
        if (this.count <= 0) {
            // 移除等待队列中的某个线程
            // 唤醒线程
        }
    }
}
