package io.effective.trans;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author luxz
 * @date 2020/6/25-4:59 PM
 */
public class MyLock {

    public static void main(String[] args) throws InterruptedException {
        Account a1 = new Account(10000);
        Account a2 = new Account(10000);
        CountDownLatch cdl = new CountDownLatch(9999);
        for (int i = 0; i < 9999; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread());
                a1.transfer(a2, 1);
                cdl.countDown();
            }).start();
        }
        cdl.await();
        System.out.println("a1=" + a1.balance);
        System.out.println("a2=" + a2.balance);
    }


    static class Account {
        private Integer balance;

        public Account(Integer balance) {
            this.balance = balance;
        }

        public void transfer(Account target, Integer amt) {
            Allocator.getInstance().apply(this, target);
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
            Allocator.getInstance().release(this, target);
        }

        public Integer getBalance() {
            return balance;
        }
    }

    static class Allocator {
        private List<Account> locks = new ArrayList<>();

        private Allocator() {
        }

        public static Allocator getInstance() {
            return AllocatorSigle.install;
        }

        static class AllocatorSigle {
            public static Allocator install = new Allocator();
        }


        public synchronized void apply(Account a1, Account a2) {
            while (locks.contains(a1) || locks.contains(a2)) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
            locks.add(a1);
            locks.add(a2);
        }

        public synchronized void release(Account a1, Account a2) {
            locks.remove(a1);
            locks.remove(a2);
            notifyAll();
        }
    }
}
