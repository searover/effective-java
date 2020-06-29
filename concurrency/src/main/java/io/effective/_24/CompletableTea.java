package io.effective._24;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author luxz
 * @date 2020/6/27-3:41 PM
 */
public class CompletableTea {
    public static void main(String[] args) {
        CompletableFuture<Void> cf1 = CompletableFuture.runAsync(() -> {
            System.out.println("T1: 洗水壶...");
            sleep(2);
            System.out.println("T1: 烧开水...");
            sleep(15);
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T2: 洗茶壶...");
            sleep(1);
            System.out.println("T2: 洗茶杯...");
            sleep(2);
            System.out.println("T2: 拿茶叶...");
            sleep(1);
            return "龙井";
        });

        CompletableFuture<String> cf3 = cf1.thenCombine(cf2, (__, tf) -> {
            System.out.println("T1: 拿到茶叶：" + tf);
            System.out.println("T1: 泡茶...");
            return "上茶：" + tf;
        });

        System.out.println(cf3.join());
    }

    static void sleep(int t) {
        try {
            TimeUnit.SECONDS.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
