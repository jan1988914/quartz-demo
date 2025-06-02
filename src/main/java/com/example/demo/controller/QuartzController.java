package com.example.demo.controller;

import com.example.demo.entity.QuartzJob;
import com.example.demo.repository.QuartzJobRepository;
import com.example.demo.repository.QuartzLogRepository;
import com.example.demo.service.QuartzJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quartz")
public class QuartzController {

    @Autowired
    private QuartzJobService quartzJobService ;

    @Autowired
    private QuartzJobRepository quartzJobRepository ;

    @GetMapping("/job/{id}")
    public QuartzJob getById(@PathVariable Integer id){
        return quartzJobService.getById(id) ;
    }

    @GetMapping("/job")
    public List<QuartzJob> findALlJob(){
        return quartzJobRepository.findAll() ;
    }

    @PostMapping("/job")
    public Integer insert(@RequestBody QuartzJob quartzJob){
        return quartzJobService.insert(quartzJob) ;
    }

    @PutMapping("/job")
    public QuartzJob update(@RequestBody QuartzJob quartzJob){
        return quartzJobService.update(quartzJob) ;
    }

    @PutMapping("/job/pause/{id}")
    public void pause(@PathVariable("id") Integer id) {
        quartzJobService.pause(id);
    }

    @PutMapping("/job/resume/{id}")
    public void resume(@PathVariable("id") Integer id) {
        quartzJobService.resume(id) ;
    }

    @GetMapping("/job/runOnce/{id}")
    public void runOnce(@PathVariable("id") Integer id) {
        quartzJobService.runOnce(id) ;
    }
}
