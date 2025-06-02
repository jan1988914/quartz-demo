package com.example.demo.service;

import com.example.demo.entity.QuartzLog;
import com.example.demo.repository.QuartzLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuartzLogService {

     @Autowired
    private QuartzLogRepository quartzLogRepository ;

    public Integer insert(QuartzLog quartzLog) {
        QuartzLog save = quartzLogRepository.save(quartzLog);
        return save.getId() ;
    }
}
