package com.bader88.springaopdemo.aop.data;

import org.springframework.stereotype.Component;

@Component
public class DataService1 {

    public int[] retrieveData(){

//        to test @Around in PerformanceTRackingAspect class
        try {
            Thread.sleep(30); // simulate
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new int[] {11,22,33,44,55};

    }
}
