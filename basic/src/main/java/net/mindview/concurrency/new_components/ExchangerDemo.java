package net.mindview.concurrency.new_components;

import net.mindview.util.Generator;

import java.util.List;
import java.util.concurrent.*;

class ExchangerProducer<T> implements Runnable {
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;

    ExchangerProducer(Exchanger<List<T>> exch, Generator<T> gen, List<T> holder) {
        this.exchanger = exch;
        this.generator = gen;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < ExchangerDemo.size; i++) {
                    holder.add(generator.next());
                }
                System.out.println("producer exchanging...");
                holder = exchanger.exchange(holder);
            }
        } catch (InterruptedException e) {
        }
    }
}

class ExchangerConsumer<T> implements Runnable {
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;

    public ExchangerConsumer(Exchanger<List<T>> exchanger, List<T> holder) {
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                holder = exchanger.exchange(holder);
                System.out.println("consumer got " + holder.size() + ".");
                for (T h : holder) {
                    value = h;
                    holder.remove(h);   // OK for CopyOnWriteArrayList
                }
            }
        } catch (InterruptedException e) {

        }
        System.out.println("Final value: " + value);
    }
}

class FatGenerator {
    static Generator create() {
        return new Generator<Fat>() {
            @Override
            public Fat next() {
                return new Fat();
            }
        };
    }
}

public class ExchangerDemo {
    static int size = 10;
    static int delay = 5;   // seconds

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<>();
        List<Fat> producerList = new CopyOnWriteArrayList<>(),
                consumerList = new CopyOnWriteArrayList<>();
        exec.execute(new ExchangerProducer<Fat>(xc, FatGenerator.create(), producerList));
        exec.execute(new ExchangerConsumer<>(xc, consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}
