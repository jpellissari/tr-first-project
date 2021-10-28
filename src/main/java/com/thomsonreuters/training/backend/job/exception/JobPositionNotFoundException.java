package com.thomsonreuters.training.backend.job.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class JobPositionNotFoundException extends ResponseStatusException {
  public JobPositionNotFoundException() {
    super(HttpStatus.NOT_FOUND, "Job Position not found.");
  }
}
