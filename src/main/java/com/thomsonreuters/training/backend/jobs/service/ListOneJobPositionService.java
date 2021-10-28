package com.thomsonreuters.training.backend.jobs.service;

import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.thomsonreuters.training.backend.jobs.entity.JobPosition;
import com.thomsonreuters.training.backend.jobs.exception.JobPositionNotFoundException;
import com.thomsonreuters.training.backend.jobs.repository.JobPositionRepository;

@Service
public class ListOneJobPositionService {
  @Autowired
  private JobPositionRepository jobPositionRepository;

  public JobPosition execute(UUID id) throws JobPositionNotFoundException {
    return this.jobPositionRepository.findById(id).orElseThrow(JobPositionNotFoundException::new);
  }
}
