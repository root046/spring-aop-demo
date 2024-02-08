package com.bader88.springaopdemo.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
    @Pointcut("execution(* com.bader88.springaopdemo.aop.*.*.*(..))")
    public void businessAndDataPackageConfig(){
    }
    @Pointcut("execution(* com.bader88.springaopdemo.aop.business.*.*(..))")
    public void businessPackageConfig(){
    }

    @Pointcut("execution(* com.bader88.springaopdemo.aop.data.*.*(..))")
    public void DataPackageConfig(){
    }

    @Pointcut("bean(*Service*)")
    public void dataPackageConfigUsingBean(){
    }

    @Pointcut("@annotation(com.bader88.springaopdemo.aop.annotations.TrackTime)")
    public void trackTimeAnnotation(){}
}
