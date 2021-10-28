package com.thomsonreuters.training.backend.jobs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.thomsonreuters.training.backend.jobs.dto.JobPositionDTO;
import com.thomsonreuters.training.backend.jobs.entity.JobPosition;
import com.thomsonreuters.training.backend.jobs.mapper.JobPositionMapper;
import com.thomsonreuters.training.backend.jobs.service.UpdateJobPositionService;

@RestController
public class UpdateJobPositionController {
  @Autowired
  private UpdateJobPositionService updateJobPositionService;
  @Autowired
  private JobPositionMapper jobPositionMapper;

  @PutMapping("/jobs/{id}")
  public ResponseEntity<Object> handle(@PathVariable String id, @RequestBody JobPositionDTO jobPositionDTO) {
    jobPositionDTO.setId(id);
    JobPosition jobPosition = jobPositionMapper.toEntity(jobPositionDTO);
    this.updateJobPositionService.execute(jobPosition);

    return ResponseEntity.ok().build();
  }
}
