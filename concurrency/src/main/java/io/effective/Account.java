package io.effective;

/**
 * @author luxz
 * @date 2020/6/25-3:17 PM
 */
public class Account {
    private int id = 0;
    private int balance = 10000;

    public Account(int id) {
        this.id = id;
    }

    void transfer(Account target, int amt) {
        // 利用id排序，让线程按顺序申请资源锁
        Account left, right;
        if (this.id > target.id) {
            left = target;
            right = this;
        } else {
            left = this;
            right = target;
        }
        synchronized (left) {
            synchronized (right) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Account a1 = new Account(1);
        Account a2 = new Account(2);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                a1.transfer(a2, 1);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                a2.transfer(a1, 1);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
