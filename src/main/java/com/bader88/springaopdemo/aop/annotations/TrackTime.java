package com.bader88.springaopdemo.aop.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Only Methods
@Target(ElementType.METHOD)
//Runtime
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackTime {
}
