package io.effective.mapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "io.effective.mapper")
public class ApplicationTest implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("AAAAAAAAAAAAA");
    }
}
