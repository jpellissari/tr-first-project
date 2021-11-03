package com.thomsonreuters.training.backend.validators;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AnyOfValidator implements ConstraintValidator<AnyOf, CharSequence> {
  private List<String> acceptedValues;

  @Override
  public void initialize(AnyOf annotation) {
    acceptedValues = Stream.of(annotation.anyOf()).collect(Collectors.toList());
  }

  @Override
  public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }

    return acceptedValues.contains(value.toString());
  }
}
