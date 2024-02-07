package com.bader88.springaopdemo.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTRackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());
    // in DataService1 class Thread.sleep(30) added To notice the time difference
    @Around("execution(* com.bader88.springaopdemo.aop.*.*.*(..))")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // start a timer`
        long startTimeMillis = System.currentTimeMillis();

        // execute the method
        Object returnVAlue = proceedingJoinPoint.proceed();
        // stop the timer
        long stopTimeMillis = System.currentTimeMillis();
        long executionDuration  = stopTimeMillis - startTimeMillis;

        logger.info("Around Aspect - {} Method executed in {} ms",
                proceedingJoinPoint,executionDuration);

        return returnVAlue;
    }
}
