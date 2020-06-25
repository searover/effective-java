package io.effective;

public class VolatileTest {
    private static int count = 0;
    private static boolean x = false;

    public synchronized static void read() {
        while (!x) {
            Thread.yield();
        }
        System.out.println("count: " + count);
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> read()).start();
        count = 42;
        x = true;
    }
}
