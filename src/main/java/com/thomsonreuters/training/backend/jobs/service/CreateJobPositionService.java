package com.thomsonreuters.training.backend.jobs.service;

import com.thomsonreuters.training.backend.jobs.entity.JobPosition;
import com.thomsonreuters.training.backend.jobs.repository.JobPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobPositionService {
  @Autowired private JobPositionRepository jobPositionRepository;

  public void execute(JobPosition jobPosition) {
    this.jobPositionRepository.save(jobPosition);
  }
}
