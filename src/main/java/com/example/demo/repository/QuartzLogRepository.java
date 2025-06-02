package com.example.demo.repository;

import com.example.demo.entity.QuartzLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartzLogRepository extends JpaRepository<QuartzLog, Integer> {
}
