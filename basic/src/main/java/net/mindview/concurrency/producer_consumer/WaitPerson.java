package net.mindview.concurrency.producer_consumer;

public class WaitPerson implements Runnable {
    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait(); // wait for the chef to produce a meal
                    }
                }
                System.out.println("WaitPerson got " + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();    // ready for another
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted.");
        }
    }
}
