package net.mindview.concurrency.waxomatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car {
    private boolean waxOn = false;

    public synchronized void waxed() {
        waxOn = true; // Read to buff
        notifyAll();
    }

    public synchronized void buffed() {
        waxOn = false; // Ready for another coat of wax
        notifyAll();
    }

    public synchronized void waitingForWaxing() throws InterruptedException {
        while (waxOn == false) {
            wait();
        }
    }

    public synchronized void waitingForBuffing() throws InterruptedException {
        while (waxOn == true) {
            wait();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car c) {
        car = c;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax On!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitingForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt.");
        }
        System.out.println("Ending Wax On task.");
    }
}

class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car c) {
        this.car = c;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitingForBuffing();
                System.out.println("Wax off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt.");
        }
        System.out.println("Ending Wax Off task.");
    }
}

public class WaxOMatic {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Shutting down.");
        exec.shutdownNow();
    }
}
