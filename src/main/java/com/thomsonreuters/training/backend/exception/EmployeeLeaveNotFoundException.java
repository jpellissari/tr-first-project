package com.thomsonreuters.training.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmployeeLeaveNotFoundException extends ResponseStatusException {
  public EmployeeLeaveNotFoundException() {
    super(HttpStatus.NOT_FOUND, "Employee leave not found.");
  }
}
