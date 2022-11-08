package io.effective;

public class Test {

    private static Test tt;

    public Test() {
        tt = this;
    }

    private long count = 0;

    private synchronized void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Test test = new Test();
        Thread t1 = new Thread(test::add10K);
        Thread t2 = new Thread(test::add10K);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(test.count);
    }
}
