package com.thomsonreuters.training.backend.jobs.mapper;

import java.util.UUID;
import com.thomsonreuters.training.backend.jobs.dto.JobPositionDTO;
import com.thomsonreuters.training.backend.jobs.entity.JobPosition;
import org.springframework.stereotype.Component;

@Component
public class JobPositionMapper {
  public JobPositionDTO toDto (JobPosition jobPosition) {
   return new JobPositionDTO(jobPosition.getIdentifier().toString(), jobPosition.getName());
  }

  public JobPosition toEntity (JobPositionDTO jobPositionDto) {
    if (jobPositionDto.getId() == null) {
      return new JobPosition(jobPositionDto.getName());
    }
    UUID uuid = UUID.fromString(jobPositionDto.getId());
    return new JobPosition(uuid, jobPositionDto.getName());
  }
}
