package com.thomsonreuters.training.backend.mappers.jobs;

import java.util.UUID;
import com.thomsonreuters.training.backend.dtos.jobs.UpdateJobPositionDTO;
import com.thomsonreuters.training.backend.entities.JobPosition;
import org.springframework.stereotype.Component;

@Component
public class UpdateJobPositionMapper {
  public JobPosition toEntity(UpdateJobPositionDTO data) {
    return new JobPosition(UUID.fromString(data.getId()), data.getName());
  }
}
