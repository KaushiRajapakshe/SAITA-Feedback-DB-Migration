package com.admin.saita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * Created by KaushiRajapakshe on 3/07/2021.
 */
/**
 * Scheduler Main class
 */

@SpringBootApplication
@EnableScheduling
public class SchedulerMain {
    public static void main(String args[]){
        SpringApplication.run(SchedulerMain.class, args);
    }
}
