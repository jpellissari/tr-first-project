package com.thomsonreuters.training.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class JobPositionNotFoundException extends ResponseStatusException {
  public JobPositionNotFoundException() {
    super(HttpStatus.NOT_FOUND, "Job Position not found.");
  }
}
