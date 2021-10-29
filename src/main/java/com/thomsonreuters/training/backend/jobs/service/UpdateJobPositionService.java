package com.thomsonreuters.training.backend.jobs.service;

import java.util.Optional;
import com.thomsonreuters.training.backend.jobs.entity.JobPosition;
import com.thomsonreuters.training.backend.jobs.exception.JobPositionNotFoundException;
import com.thomsonreuters.training.backend.jobs.repository.JobPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateJobPositionService {
  @Autowired private JobPositionRepository jobPositionRepository;

  public void execute(JobPosition jobPosition) {
    Optional<JobPosition> findJobPosition =
        this.jobPositionRepository.findById(jobPosition.getIdentifier());
    if (findJobPosition.isEmpty()) {
      throw new JobPositionNotFoundException();
    }

    this.jobPositionRepository.save(jobPosition);
  }
}
