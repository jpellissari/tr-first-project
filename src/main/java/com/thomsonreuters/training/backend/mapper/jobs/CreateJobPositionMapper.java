package com.thomsonreuters.training.backend.mapper.jobs;

import com.thomsonreuters.training.backend.dto.jobs.CreateJobPositionDTO;
import com.thomsonreuters.training.backend.model.JobPosition;
import org.springframework.stereotype.Component;

@Component
public class CreateJobPositionMapper {
  public JobPosition toEntity(CreateJobPositionDTO data) {
    return new JobPosition(data.getName());
  }
}
