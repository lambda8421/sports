package com.mofei.sports.crawler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Job {
    public final static long ONE_Minute =  60 * 1000;
    public final static long ONE_Hour =  60 * 60 * 1000;

    @Scheduled(fixedDelay=ONE_Hour)
    public void fixedDelayJob(){
        System.out.println(new Date()+" >>fixedDelay执行....");
    }

    @Scheduled(fixedRate=ONE_Hour)
    public void fixedRateJob(){
        System.out.println(new Date()+" >>fixedRate执行....");
    }

    @Scheduled(cron="0 15 3 * * ?")
    public void cronJob(){
        System.out.println(new Date()+" >>cron执行....");
    }
}
