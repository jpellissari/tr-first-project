package com.thomsonreuters.training.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ClientNotFoundException extends ResponseStatusException {
  public ClientNotFoundException() {
    super(HttpStatus.NOT_FOUND, "Client not found.");
  }
}
