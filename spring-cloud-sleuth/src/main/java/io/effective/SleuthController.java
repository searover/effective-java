package io.effective;

import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;

/**
 * @author luxz
 * @date 2022/9/13-18:48
 */
@RestController
public class SleuthController {

    private static final Logger logger = LoggerFactory.getLogger(SleuthController.class);

    @Autowired
    private SleuthService sleuthService;

    @Autowired
    private Executor executor;

    @GetMapping("/")
    public String helloSleuth() {
        logger.info("Hello, Sleuth.");
        return "success";
    }

    @GetMapping("/same-span")
    public String helloSleuthSameSpan() throws InterruptedException {
        logger.info("Same Span");
        sleuthService.doSomeWorkSameSpan();
        return "success";
    }

    @GetMapping("/new-span")
    public String helloSleuthNewSpan() throws InterruptedException {
        logger.info("New Span");
        sleuthService.doSomeWorkNewSpan();
        return "success";
    }

    @GetMapping("/new-thread")
    public String helloSleuthNewThread() {
        logger.info("New Thread");
        var runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("I'm inside the new thread - with a new span");

            }
        };
        executor.execute(runnable);
        logger.info("I'm done - with the original span");
        return "success";
    }

    @GetMapping("/async")
    public String helloSleuthAsync() throws InterruptedException {
        logger.info("Before async method call");
        sleuthService.asyncMethod();
        logger.info("After async method call");

        return "success";
    }
}
