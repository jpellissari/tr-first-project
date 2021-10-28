package com.thomsonreuters.training.backend.job.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.thomsonreuters.training.backend.job.dto.JobPositionDTO;
import com.thomsonreuters.training.backend.job.entity.JobPosition;
import com.thomsonreuters.training.backend.job.mapper.JobPositionMapper;
import com.thomsonreuters.training.backend.job.service.CreateJobPositionService;

@RestController
public class CreateJobPositionController {
  @Autowired
  private CreateJobPositionService createJobPositionService;
  @Autowired
  private JobPositionMapper jobPositionMapper;

  @PostMapping("/jobs")
  public ResponseEntity<Object> handle(@RequestBody JobPositionDTO jobPositionDto) {

    JobPosition jobPosition = jobPositionMapper.toEntity(jobPositionDto);
    createJobPositionService.execute(jobPosition);
    return ResponseEntity.status(201).build();
  }
}