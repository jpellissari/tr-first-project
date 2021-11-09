package com.thomsonreuters.training.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmployeeCanNotHaveMoreLeavesException extends ResponseStatusException {
  public EmployeeCanNotHaveMoreLeavesException(String cause) {
    super(HttpStatus.BAD_REQUEST, "Already has " + cause + ".");
  }
}
