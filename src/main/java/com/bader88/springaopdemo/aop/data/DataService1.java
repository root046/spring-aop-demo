package com.bader88.springaopdemo.aop.data;

import org.springframework.stereotype.Component;

@Component
public class DataService1 {

    public int[] retrieveData(){
        return new int[] {11,22,33,44,55};

    }
}
