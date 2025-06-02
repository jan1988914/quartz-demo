package com.example.demo.service;

import com.example.demo.constant.JobState;
import com.example.demo.entity.QuartzJob;
import com.example.demo.repository.QuartzJobRepository;
import com.example.demo.scheduler.QuartzManage;
import jakarta.annotation.PostConstruct;
import org.quartz.CronTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class QuartzJobService {

    @Autowired
    QuartzJobRepository quartzJobRepository;

    @Autowired
    private QuartzManage quartzManage;
    @PostConstruct
    public void init () {

        List<QuartzJob> jobList = quartzJobRepository.findAll();
        jobList.forEach(quartzJob -> {
            CronTrigger cronTrigger = quartzManage.getCronTrigger(quartzJob.getId()) ;
            if (Objects.isNull(cronTrigger)){
                quartzManage.createJob(quartzJob);
            } else {
                quartzManage.updateJob(quartzJob);
            }
        });
    }

    public QuartzJob getById(Integer id) {
        return quartzJobRepository.findById(id).orElse(null) ;
    }

    public int insert(QuartzJob quartzJob) {
        QuartzJob save = quartzJobRepository.save(quartzJob);
        if (save !=null){
            quartzManage.createJob(quartzJob) ;
        }
        return save.getId();
    }

    public QuartzJob update(QuartzJob quartzJob) {
        QuartzJob save = quartzJobRepository.save(quartzJob);
        if (save !=null){
            quartzManage.updateJob(quartzJob);
        }
        return save;
    }

    public void pause(Integer id) {
        QuartzJob quartzJob = quartzJobRepository.findById(id).orElse(null) ;
        if (!Objects.isNull(quartzJob)){
            quartzJob.setState(JobState.JOB_STOP.getStatus());
            quartzJobRepository.save(quartzJob);
            quartzManage.checkStop(quartzJob);
        }
    }

    public void resume(Integer id) {
        QuartzJob quartzJob = quartzJobRepository.findById(id).orElse(null) ;
        if (!Objects.isNull(quartzJob)){
            quartzJob.setState(JobState.JOB_RUN.getStatus());
            quartzJobRepository.save(quartzJob);
            quartzManage.resumeJob(id);
            }
        }

    public void runOnce(Integer id) {
        QuartzJob quartzJob = quartzJobRepository.findById(id).orElse(null) ;
        if (!Objects.isNull(quartzJob) && quartzJob.getState() != JobState.JOB_DEL.getStatus()){
            quartzManage.run(quartzJob);
        }
    }

}
