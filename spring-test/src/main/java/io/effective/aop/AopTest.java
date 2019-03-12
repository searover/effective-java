package io.effective.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class AopTest {

//    @Before("execution(* io.effective.service.AccountService.*(..))")
//    @Before("@target(org.springframework.web.bind.annotation.RestController)")
//    @Before("execution(* io.effective.controller.AccountController(..))")
    public void beforeInvoke() {
        System.out.println("Before advice invoked...");
    }
}
