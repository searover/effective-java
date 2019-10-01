package net.mindview.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

class LiftOffRunner implements Runnable {

    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }

    public void add(LiftOff lo) {
        try {
            rockets.put(lo);
        } catch (InterruptedException e) {
            System.out.println("Interrupted during put().");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff lo = rockets.take();
                lo.run();
            }
        } catch (InterruptedException e) {
            System.out.println("Waking from take().");
        }
        System.out.println("Exiting LiftOffRunner.");
    }
}

public class TestBlockingQueues {
    static void getKey() throws IOException {
        new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

    static void getKey(String message) throws IOException {
        System.out.println(message);
        getKey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) throws IOException {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }
        getKey("Press 'Enter' (" + msg + ")");
        t.interrupt();
        System.out.println("Finished " + msg + " test.");
    }

    public static void main(String[] args) throws IOException {
        test("LinkedBlockingQueue", new LinkedBlockingQueue<>());
        test("ArrayBlockingQueue", new ArrayBlockingQueue<>(3));
        test("SynchronousQueue", new SynchronousQueue<>());
    }
}
