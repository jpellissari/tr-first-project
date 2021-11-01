package com.thomsonreuters.training.backend.mapper.jobs;

import java.util.UUID;
import com.thomsonreuters.training.backend.dto.jobs.JobPositionDTO;
import com.thomsonreuters.training.backend.model.JobPosition;
import org.springframework.stereotype.Component;

@Component
public class JobPositionMapper {
  public JobPositionDTO toDto(JobPosition jobPosition) {
    return new JobPositionDTO(jobPosition.getIdentifier().toString(), jobPosition.getName());
  }

  public JobPosition toEntity(JobPositionDTO jobPositionDto) {
    UUID uuid = UUID.fromString(jobPositionDto.getId());
    return new JobPosition(uuid, jobPositionDto.getName());
  }
}
