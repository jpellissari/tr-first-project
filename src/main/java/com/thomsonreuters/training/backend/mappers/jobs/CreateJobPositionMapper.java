package com.thomsonreuters.training.backend.mappers.jobs;

import com.thomsonreuters.training.backend.dtos.jobs.CreateJobPositionDTO;
import com.thomsonreuters.training.backend.entities.JobPosition;
import org.springframework.stereotype.Component;

@Component
public class CreateJobPositionMapper {
  public JobPosition toEntity(CreateJobPositionDTO data) {
    return new JobPosition(data.getName());
  }
}
