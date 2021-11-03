package com.thomsonreuters.training.backend.validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<Date, String> {
  private String pattern;

  @Override
  public void initialize(Date constraintAnnotation) {
    this.pattern = constraintAnnotation.pattern();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }

    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

    try {
      LocalDate.parse(value, dateFormatter);
      return true;
    } catch (DateTimeParseException e) {
      return false;
    }
  }
}
