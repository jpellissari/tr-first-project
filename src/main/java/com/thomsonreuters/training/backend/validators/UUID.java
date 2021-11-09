package com.thomsonreuters.training.backend.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({FIELD, METHOD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = UUIDValidator.class)
public @interface UUID {
  String message() default "{com.thomsonreuters.training.backend.validators.UUID.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
