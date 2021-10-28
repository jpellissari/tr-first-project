package com.thomsonreuters.training.backend.job.controller;

import java.util.List;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.thomsonreuters.training.backend.job.dto.JobPositionDTO;
import com.thomsonreuters.training.backend.job.entity.JobPosition;
import com.thomsonreuters.training.backend.job.mapper.JobPositionMapper;
import com.thomsonreuters.training.backend.job.service.ListAllJobPositionService;

@RestController
public class ListAllJobPositionController {
  @Autowired
  private ListAllJobPositionService listAllJobPositionService;
  @Autowired
  private JobPositionMapper jobPositionMapper;

  @GetMapping("/jobs")
  public ResponseEntity<List<JobPositionDTO>> handle() {
    List<JobPosition> jobPositions = listAllJobPositionService.execute();

    List<JobPositionDTO> jobPositionsDto = new ArrayList<>();
    for (JobPosition jobPosition : jobPositions) {
      jobPositionsDto.add(jobPositionMapper.toDto(jobPosition));
    }

    return ResponseEntity.ok().body(jobPositionsDto);
  }
}
