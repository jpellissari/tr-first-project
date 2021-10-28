package com.thomsonreuters.training.backend.job.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.thomsonreuters.training.backend.job.entity.JobPosition;
import com.thomsonreuters.training.backend.job.repository.JobPositionRepository;

@Service
public class ListAllJobPositionService {
  @Autowired
  private JobPositionRepository jobPositionRepository;

  public List<JobPosition> execute() {
    return this.jobPositionRepository.findAll();
  }
}
