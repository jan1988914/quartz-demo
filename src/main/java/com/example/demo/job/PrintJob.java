package com.example.demo.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PrintJob implements JobService{
    @Override
    public void run(String params) {
        log.info("打印任务开始执行，参数为：{}", params);
    }
}
