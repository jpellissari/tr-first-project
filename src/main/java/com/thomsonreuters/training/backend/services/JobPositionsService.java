package com.thomsonreuters.training.backend.services;

import java.util.List;
import java.util.UUID;
import com.thomsonreuters.training.backend.entities.JobPosition;
import com.thomsonreuters.training.backend.exceptions.JobPositionNotFoundException;
import com.thomsonreuters.training.backend.repositories.JobPositionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPositionsService {
  @Autowired private JobPositionsRepository jobPositionsRepository;

  public List<JobPosition> getAll() {
    return jobPositionsRepository.findAll();
  }

  public JobPosition get(UUID id) throws JobPositionNotFoundException {
    return jobPositionsRepository.findById(id).orElseThrow(JobPositionNotFoundException::new);
  }

  public JobPosition create(JobPosition jobPosition) {
    return jobPositionsRepository.save(jobPosition);
  }

  public JobPosition update(JobPosition jobPosition) {
    jobPositionsRepository
        .findById(jobPosition.getIdentifier())
        .orElseThrow(JobPositionNotFoundException::new);

    return jobPositionsRepository.save(jobPosition);
  }

  public void delete(UUID id) throws JobPositionNotFoundException {
    JobPosition jobPosition =
        jobPositionsRepository.findById(id).orElseThrow(JobPositionNotFoundException::new);

    jobPositionsRepository.delete(jobPosition);
  }
}
