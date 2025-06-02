package com.example.demo.repository;

import com.example.demo.entity.QuartzJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartzJobRepository extends JpaRepository<QuartzJob, Integer> {
}
