package com.thomsonreuters.training.backend.mappers.jobs;

import java.util.UUID;
import com.thomsonreuters.training.backend.dtos.jobs.JobPositionDTO;
import com.thomsonreuters.training.backend.entities.JobPosition;
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
