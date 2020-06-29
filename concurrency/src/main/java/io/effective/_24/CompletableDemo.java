package io.effective._24;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author luxz
 * @date 2020/6/30-6:38 AM
 */
public class CompletableDemo {
    public static void main(String[] args) {
        CompletableFuture<String> f0 = CompletableFuture.supplyAsync(() -> "Hello World!").thenApply(s -> s + "QQ").thenApply(String::toUpperCase);
        System.out.println(f0.join());
        System.out.println("================");
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            int t = new Random().nextInt(10);
            System.out.println("t1:" + t);
            try {
                TimeUnit.SECONDS.sleep(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return String.valueOf(t);
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            int t = new Random().nextInt(10);
            System.out.println("t2:" + t);
            try {
                TimeUnit.SECONDS.sleep(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return String.valueOf(t);
        });
        CompletableFuture<String> f3 = f1.applyToEither(f2, s -> s);
        System.out.println(f3.join());

        CompletableFuture<Integer> f4 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread());
            return 7 / 0;
        }).thenApply(r -> r * 10).whenCompleteAsync((integer, throwable) -> {
            System.out.println("When complete: " + Thread.currentThread() + "," + throwable);
        }).exceptionally(e -> 0);
        System.out.println(Thread.currentThread());
        System.out.println(f4.join());
    }
}
