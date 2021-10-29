package com.thomsonreuters.training.backend.jobs.controller;

import java.util.ArrayList;
import java.util.List;
import com.thomsonreuters.training.backend.jobs.dto.JobPositionDTO;
import com.thomsonreuters.training.backend.jobs.entity.JobPosition;
import com.thomsonreuters.training.backend.jobs.mapper.JobPositionMapper;
import com.thomsonreuters.training.backend.jobs.service.ListAllJobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListAllJobPositionController {
  @Autowired private ListAllJobPositionService listAllJobPositionService;
  @Autowired private JobPositionMapper jobPositionMapper;

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
