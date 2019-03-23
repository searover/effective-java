package io.effective.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AnnotationDrivenContextStartedListener {

    @EventListener
    public void handleContextStart(ContextStartedEvent cse) {
        log.info("==============Handling context started event.");
    }

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent cre) {
        log.info("==============Handling context refresh event.");
    }

    @EventListener
    public void handleContextStop(ContextStoppedEvent cse) {
        log.info("==============Handling context stop event.");
    }

    @EventListener
    public void handleContextClose(ContextClosedEvent cce) {
        log.info("==============Handling context close event.");
    }
}
