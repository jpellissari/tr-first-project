package com.thomsonreuters.training.backend.job.controller;

import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.thomsonreuters.training.backend.job.dto.JobPositionDTO;
import com.thomsonreuters.training.backend.job.entity.JobPosition;
import com.thomsonreuters.training.backend.job.mapper.JobPositionMapper;
import com.thomsonreuters.training.backend.job.service.ListOneJobPositionService;

@RestController
public class ListOneJobPositionController {
  @Autowired
  private ListOneJobPositionService listOneJobPositionService;
  @Autowired
  private JobPositionMapper jobPositionMapper;

  @GetMapping("/jobs/{id}")
  public JobPositionDTO handle(@PathVariable String id) {
    UUID uuid = UUID.fromString(id);

    JobPosition client = this.listOneJobPositionService.execute(uuid);

    return jobPositionMapper.toDto(client);
  }
}
