package net.mindview.concurrency.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedDiningPhilosophers {
    public static void main(String[] args) throws Exception {
        int ponder = 0;
        int size = 5;
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
        }
        for (int i = 0; i < size; i++) {
            if (i < (size - 1)) {
                exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));
            } else {
                exec.execute(new Philosopher(sticks[(i + 1) % size], sticks[i], i, ponder));
            }
        }
        TimeUnit.SECONDS.sleep(30);
        exec.shutdownNow();
    }
}
