package com.thomsonreuters.training.backend.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.thomsonreuters.training.backend.dto.employees.CreateEmployeeLeaveDTO;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyAccessorFactory;

public class RequireIfAnotherFieldIsValidator
    implements ConstraintValidator<RequireIfAnotherFieldIs, CreateEmployeeLeaveDTO> {
  private String requiredField;
  private String controlField;
  private String expectedFieldValue;

  @Override
  public void initialize(RequireIfAnotherFieldIs constraintAnnotation) {
    this.requiredField = constraintAnnotation.require();
    this.controlField = constraintAnnotation.when();
    this.expectedFieldValue = constraintAnnotation.is();
  }

  @Override
  public boolean isValid(CreateEmployeeLeaveDTO data, ConstraintValidatorContext context) {
    if (data == null) {
      return true;
    }

    try {
      Object controlFieldValue =
          PropertyAccessorFactory.forBeanPropertyAccess(data).getPropertyValue(controlField);
      Object requiredFieldValue =
          PropertyAccessorFactory.forBeanPropertyAccess(data).getPropertyValue(requiredField);

      if (controlFieldValue == null) {
        return true;
      }

      if (expectedFieldValue.equals(controlFieldValue.toString()) && requiredFieldValue == null) {
        context.disableDefaultConstraintViolation();
        context
            .buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
            .addPropertyNode(requiredField)
            .addConstraintViolation();
        return false;
      }

    } catch (BeansException ex) {
      return false;
    }

    return true;
  }
}
