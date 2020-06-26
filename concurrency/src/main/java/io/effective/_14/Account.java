package io.effective._14;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luxz
 * @date 2020/6/26-11:00 AM
 */
public class Account {
    private int balance;
    private final Lock lock = new ReentrantLock();

    void transfer(Account target, int amt) {
        System.out.println("transfer");
        boolean success = false;
        while (true) {
            if (this.lock.tryLock()) {
                try {
                    if (target.lock.tryLock()) {
                        try {
                            this.balance -= amt;
                            target.balance += amt;
                            System.out.println(this.balance + "," + target.balance);
                            success = true;
                        } finally {
                            target.lock.unlock();
                        }
                    }
                } finally {
                    this.lock.unlock();

                }
            }
            if (success) {
                System.out.println(success);
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Account a1 = new Account();
        Account a2 = new Account();
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                new Thread(() -> a1.transfer(a2, 1)).start();
            } else {
                new Thread(() -> a2.transfer(a1, 1)).start();
            }
        }
        Thread.sleep(1000 * 600);
    }
}
