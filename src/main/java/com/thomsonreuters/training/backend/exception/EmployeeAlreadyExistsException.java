package com.thomsonreuters.training.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmployeeAlreadyExistsException extends ResponseStatusException {
  public EmployeeAlreadyExistsException() {
    super(HttpStatus.CONFLICT, "Employee already exists.");
  }
}
