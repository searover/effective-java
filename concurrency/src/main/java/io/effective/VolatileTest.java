package io.effective;

import java.util.concurrent.TimeUnit;

public class VolatileTest {
    int count = 0;
    private static volatile boolean x = false;

    public void read() {
        int a = count;
        int b = count;
        int c = count;
        int d = count;
        System.out.println(a + "," + b + "," + c + "," + d);
    }

    public void inc() {
        count++;
        for (int i = 0; i < 50000; i++) {
            count++;
        }
        x = true;
        System.out.println("inced.");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest vt = new VolatileTest();
        Thread t1 = new Thread(() -> vt.inc());
        Thread t2 = new Thread(() -> vt.read());
//        TimeUnit.MILLISECONDS.sleep(0);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("===");
        TestRunner tr = new TestRunner();
        Thread t = new Thread(tr);
        t.start();
        TimeUnit.MILLISECONDS.sleep(0);
        tr.stop();
        System.out.println(tr.getCount());
    }
}

class TestRunner implements Runnable {
    private int count = 0;
    private volatile boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            count++;
        }
    }

    public void stop() {
        stop = true;
    }

    public int getCount() {
        return count;
    }
}
