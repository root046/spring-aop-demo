package com.bader88.springaopdemo.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration // Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.
@Aspect // Indicates that this class is an aspect.
public class LoggingAspects {

    private Logger logger = LoggerFactory.getLogger(getClass()); // Initializing a Logger instance for logging messages.

    //Pointcut - When?
    // execution(* PACKAGE.*.*(..))
    @Before("execution(* com.bader88.springaopdemo.aop.*.*.*(..))") // AspectJ pointcut expression specifying when the advice should be executed.
    public void logMethodCall(JoinPoint joinPoint){ // Advice method that logs information before method execution.
        logger.info("Before Aspect - Method is called - {}", joinPoint); // Logging a message before method execution.
    }
}
