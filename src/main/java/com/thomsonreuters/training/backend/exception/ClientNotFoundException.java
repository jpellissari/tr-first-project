package com.thomsonreuters.training.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ClientNotFoundException extends ResponseStatusException {
  public ClientNotFoundException() {
    super(HttpStatus.NOT_FOUND, "Client not found.");
  }
}
