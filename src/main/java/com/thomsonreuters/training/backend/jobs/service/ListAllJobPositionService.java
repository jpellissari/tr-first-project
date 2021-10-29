package com.thomsonreuters.training.backend.jobs.service;

import java.util.List;
import com.thomsonreuters.training.backend.jobs.entity.JobPosition;
import com.thomsonreuters.training.backend.jobs.repository.JobPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListAllJobPositionService {
  @Autowired private JobPositionRepository jobPositionRepository;

  public List<JobPosition> execute() {
    return this.jobPositionRepository.findAll();
  }
}
