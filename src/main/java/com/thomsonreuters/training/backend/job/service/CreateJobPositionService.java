package com.thomsonreuters.training.backend.job.service;

import com.thomsonreuters.training.backend.job.entity.JobPosition;
import com.thomsonreuters.training.backend.job.repository.JobPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobPositionService {
  @Autowired
  private JobPositionRepository jobPositionRepository;

  public void execute(JobPosition jobPosition) {
    this.jobPositionRepository.save(jobPosition);
  }
}
