package com.admin.saita;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * Created by KaushiRajapakshe on 3/07/2021.
 */
/**
 * Scheduler cronjob define
 */

@Component
public class Scheduler {
    // every second
    // * * * ? * *
    // Seconds	Minutes	Hours	Day Of Month	Month	Day Of Week	Year
    // *	    0	    0	    ?	            *	    *	        *
    // every minutes
    @Scheduled(cron = "0 * * * * ?")
    public void cronJobSch() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);
    }

    // @Scheduled(fixedDelay = 1000, initialDelay = 3000)
    // public void fixedRateSch() {
    //     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    //
    //     Date now = new Date();
    //     String strDate = sdf.format(now);
    //     System.out.println("Fixed Rate scheduler:: " + strDate);
    // }
}
