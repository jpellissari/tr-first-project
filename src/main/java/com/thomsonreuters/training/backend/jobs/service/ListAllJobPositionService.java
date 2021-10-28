package com.thomsonreuters.training.backend.jobs.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.thomsonreuters.training.backend.jobs.entity.JobPosition;
import com.thomsonreuters.training.backend.jobs.repository.JobPositionRepository;

@Service
public class ListAllJobPositionService {
  @Autowired
  private JobPositionRepository jobPositionRepository;

  public List<JobPosition> execute() {
    return this.jobPositionRepository.findAll();
  }
}
