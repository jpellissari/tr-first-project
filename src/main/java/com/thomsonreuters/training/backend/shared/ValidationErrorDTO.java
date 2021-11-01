package com.thomsonreuters.training.backend.shared;

public class ValidationErrorDTO {
  private final String field;
  private final String error;

  public ValidationErrorDTO(String field, String error) {
    this.field = field;
    this.error = error;
  }

  public String getField() {
    return field;
  }

  public String getError() {
    return error;
  }
}
