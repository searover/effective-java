package io.effective.event;

import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class AsynchronousSpringEventsConfig {

    @Bean
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        val caster = new SimpleApplicationEventMulticaster();
        caster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return caster;
    }
}
