package com.example.demo.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class TimerJob implements JobService{

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
    @Override
    public void run(String params) {
        log.info("\n ======== \n timer-job-params:{} \n ========",params);
        log.info("time-now:{}",format.format(new Date()));
    }
}
