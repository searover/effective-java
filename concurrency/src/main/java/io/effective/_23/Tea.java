package io.effective._23;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author luxz
 * @date 2020/6/27-3:23 PM
 */
public class Tea {

    static class T1Task implements Callable<String> {
        FutureTask<String> ft2;

        public T1Task(FutureTask<String> ft2) {
            this.ft2 = ft2;
        }

        @Override
        public String call() throws Exception {
            System.out.println("T1: 洗水壶...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("T1: 烧开水...");
            TimeUnit.SECONDS.sleep(15);
            // 获取T2线程的茶叶
            String tf = ft2.get();
            System.out.println("T1: 拿到茶叶：" + tf);
            System.out.println("T1: 泡茶...");
            return "上荼：" + tf;
        }
    }

    static class T2Task implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("T2: 洗茶壶...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("T2: 洗茶杯...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("T2: 拿茶叶...");
            TimeUnit.SECONDS.sleep(1);
            return "龙井";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> ft2 = new FutureTask<>(new T2Task());
        FutureTask<String> ft1 = new FutureTask<>(new T1Task(ft2));

        new Thread(ft1).start();
        new Thread(ft2).start();
        System.out.println(ft1.get());
    }
}
