package com.thomsonreuters.training.backend.mapper.jobs;

import java.util.UUID;
import com.thomsonreuters.training.backend.dto.jobs.UpdateJobPositionDTO;
import com.thomsonreuters.training.backend.model.JobPosition;
import org.springframework.stereotype.Component;

@Component
public class UpdateJobPositionMapper {
  public JobPosition toEntity(UpdateJobPositionDTO data) {
    return new JobPosition(UUID.fromString(data.getId()), data.getName());
  }
}
