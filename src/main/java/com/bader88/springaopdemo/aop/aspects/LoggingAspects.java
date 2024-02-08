package com.bader88.springaopdemo.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration // Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.
@Aspect // Indicates that this class is an aspect.
public class LoggingAspects {

    private Logger logger = LoggerFactory.getLogger(getClass()); // Initializing a Logger instance for logging messages.

    //Pointcut - When?
    // execution(* PACKAGE.*.*(..))
    @Before("com.bader88.springaopdemo.aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()") // take pointcut from CommonPointcutConfig class.
    public void logMethodCallBeforeExecution(JoinPoint joinPoint){ // Advice method that logs information before method execution.
        logger.info("Before Aspect Method - {} is called with arguments : {}",
                joinPoint,joinPoint.getArgs()); // Logging a message before method execution.
    }
    @After("com.bader88.springaopdemo.aop.aspects.CommonPointcutConfig.businessPackageConfig()") // take pointcut from CommonPointcutConfig class.
    public void logMethodCallAfterExecution(JoinPoint joinPoint){ // Advice method that logs information before method execution.
        logger.info("After Aspect Method - {} has executed or thrown", joinPoint); //Logging a message after a method execution or throws an exception.
    }

    // Executed after an exception is thrown
    // see BusinessService1.calculateMax() to test @AfterThrowing un-comment below throw, and comment the return
    @AfterThrowing(
            pointcut = "com.bader88.springaopdemo.aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()", // take pointcut from CommonPointcutConfig class.
            throwing = "exception" // Parameter name to store the thrown exception
    )
    public void logMethodCallAfterThrowingException(JoinPoint joinPoint, Exception exception){ // Method to log information after an exception is thrown
        logger.info("After Throwing Aspect Method - {} has thrown an exception: {}", joinPoint, exception); // Logging message after an exception is thrown
    }

    // Executed after a successful execution
    @AfterReturning(
            pointcut = "com.bader88.springaopdemo.aop.aspects.CommonPointcutConfig.DataPackageConfig()", // take pointcut from CommonPointcutConfig class.
            returning = "resultValue" // Parameter name to store the returned value
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue){ // Method to log information after a successful method execution
        logger.info("After Successful Execution Aspect Method - {} and return: {}", joinPoint, resultValue); // Logging message after a successful method execution
    }

}
