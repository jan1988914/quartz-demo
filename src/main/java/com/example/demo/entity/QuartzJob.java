package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class QuartzJob implements Serializable {
    /**
     * 任务调度参数key
     */
    public static final String JOB_PARAM_KEY = "BOOT_JOB_PARAM_KEY";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    @Column(columnDefinition = "CHAR(36)")
    private Integer id;

    private String beanName;

    private String params;

    private String cronExpres;

    private Integer state;

    private String remark;

    private Date createTime;
}