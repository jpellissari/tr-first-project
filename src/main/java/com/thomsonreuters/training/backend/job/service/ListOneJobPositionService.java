package com.thomsonreuters.training.backend.job.service;

import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.thomsonreuters.training.backend.job.entity.JobPosition;
import com.thomsonreuters.training.backend.job.exception.JobPositionNotFoundException;
import com.thomsonreuters.training.backend.job.repository.JobPositionRepository;

@Service
public class ListOneJobPositionService {
  @Autowired
  private JobPositionRepository jobPositionRepository;

  public JobPosition execute(UUID id) throws JobPositionNotFoundException {
    return this.jobPositionRepository.findById(id).orElseThrow(JobPositionNotFoundException::new);
  }
}
