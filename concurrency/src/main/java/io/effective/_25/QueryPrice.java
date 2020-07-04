package io.effective._25;

import java.util.concurrent.*;

/**
 * @author luxz
 * @date 2020/6/30-7:28 AM
 * 异步询价系统
 */
public class QueryPrice {
    static int getPriceS1() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 10;
    }

    static int getPriceS2() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 15;
    }

    static int getPriceS3() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 5;
    }

    static void save(int price) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void run1() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Integer> f1 = executor.submit(QueryPrice::getPriceS1);
        Future<Integer> f2 = executor.submit(QueryPrice::getPriceS2);
        Future<Integer> f3 = executor.submit(QueryPrice::getPriceS3);
        Integer r1 = f1.get();// 如果这里耗时很长，会导致主线程阻塞，即使f2,f3响应很快，也不会先执行
        executor.execute(() -> save(r1));
        Integer r2 = f2.get();
        executor.execute(() -> save(r2));
        Integer r3 = f3.get();
        executor.execute(() -> save(r3));
    }

    static void run2() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(); // 利用阻塞队列实现先获取的报价先保存到数据库
        executor.execute(() -> {
            int price = QueryPrice.getPriceS1();
            try {
                queue.put(price);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            int price = QueryPrice.getPriceS2();
            try {
                queue.put(price);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            int price = QueryPrice.getPriceS3();
            try {
                queue.put(price);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        for (int i = 0; i < 3; i++) {
            int price = queue.take();
            executor.execute(() -> save(price));
        }
    }

    static void run3() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletionService<Integer> cs = new ExecutorCompletionService<>(executor);
        cs.submit(QueryPrice::getPriceS1);
        cs.submit(QueryPrice::getPriceS2);
        cs.submit(QueryPrice::getPriceS3);
        for (int i = 0; i < 3; i++) {
            int price = cs.take().get();
            executor.execute(() -> save(price));
        }
    }
}
