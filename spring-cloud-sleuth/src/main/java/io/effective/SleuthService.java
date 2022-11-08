package io.effective;

import brave.Tracer;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author luxz
 * @date 2022/9/13-18:59
 */
@Service
public class SleuthService {
    private static final Logger logger = LoggerFactory.getLogger(SleuthService.class);

    @Autowired
    private Tracer tracer;

    public void doSomeWorkSameSpan() throws InterruptedException {
        Thread.sleep(1000L);
        logger.info("Doing some work");
    }

    public void doSomeWorkNewSpan() throws InterruptedException {
        logger.info("I'm in the original span.");
        var newSpan = tracer.nextSpan().name("newSpan").start();
        try (var ws = tracer.withSpanInScope(newSpan.start())) {
            Thread.sleep(1000L);
            logger.info("I'm in the new span doing some cool work that needs its own span");
        } finally {
            newSpan.finish();
        }
        logger.info("I'm in the original span");
    }

    @Async
    public void asyncMethod() throws InterruptedException {
        logger.info("Start async method");
        Thread.sleep(1000L);
        logger.info("End async method");
    }
}
