package io.effective;

import io.effective.event.CustomSpringEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

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
    }
}