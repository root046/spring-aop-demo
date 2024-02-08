package com.bader88.springaopdemo.aop.business;

import com.bader88.springaopdemo.aop.annotations.TrackTime;
import com.bader88.springaopdemo.aop.data.DataService1;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    private DataService1 dataService1;

    public BusinessService1(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }

    @TrackTime
    public int calculateMax(){
        int[] data = dataService1.retrieveData();

//        to test @AfterThrowing un-comment below throw, and comment the return
//        throw new RuntimeException("Something Went Wrong");
        return Arrays.stream(data).max().orElse(0);
    }
}
