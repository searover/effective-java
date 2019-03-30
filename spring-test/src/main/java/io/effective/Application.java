package io.effective;

import io.effective.event.CustomSpringEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;

import static io.effective.utils.SimpleDateFormatTest.parseDate;

@Slf4j
@EnableAsync
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CustomSpringEventPublisher publisher;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        publisher.doStuffAndPublishAnEvent("Hello");
        publisher.doStuffAndPublishAnEvent("Hello");
        ThreadFactory threadFactory = new ThreadFactory() {
            private int count = 0;

            @Override
            public Thread newThread(Runnable r) {
                ThreadGroup tg = new ThreadGroup("Hello");
                return new Thread(tg, r, tg.getName() + "-" + count++);
            }
        };
        ExecutorService pool = new ThreadPoolExecutor(5, 200, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(1024), threadFactory);
        for (int i = 0; i < 100; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    log.info(parseDate("2019-03-21 11:11:11") + "");
                }
            });
        }
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.HOURS);
    }
}