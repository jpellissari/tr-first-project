package com.thomsonreuters.training.backend.jobs.controller;

import com.thomsonreuters.training.backend.jobs.dto.JobPositionDTO;
import com.thomsonreuters.training.backend.jobs.entity.JobPosition;
import com.thomsonreuters.training.backend.jobs.mapper.JobPositionMapper;
import com.thomsonreuters.training.backend.jobs.service.CreateJobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateJobPositionController {
  @Autowired private CreateJobPositionService createJobPositionService;
  @Autowired private JobPositionMapper jobPositionMapper;

  @PostMapping("/jobs")
  public ResponseEntity<Object> handle(@RequestBody JobPositionDTO jobPositionDto) {

    JobPosition jobPosition = jobPositionMapper.toEntity(jobPositionDto);
    createJobPositionService.execute(jobPosition);
    return ResponseEntity.status(201).build();
  }
}
