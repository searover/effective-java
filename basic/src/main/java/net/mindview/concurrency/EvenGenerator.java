package net.mindview.concurrency;

public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
//        try {
//            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(50));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Thread.yield();
//        ++currentEvenValue;
        return ++currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator(), 1000);
    }
}
