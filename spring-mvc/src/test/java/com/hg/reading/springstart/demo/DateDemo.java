package com.hg.reading.springstart.demo;


import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class DateDemo {

    @Test
    public void setSqlDate(){
        System.out.println(DateDemo.getCurrentTime());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(DateDemo.getCurrentTime());
    }

    public static Date getCurrentTime(){
        return new Date();
    }

    @Test
    public void one(){

    }
}
