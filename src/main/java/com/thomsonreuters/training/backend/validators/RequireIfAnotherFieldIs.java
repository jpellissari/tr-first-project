package com.thomsonreuters.training.backend.validators;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = RequireIfAnotherFieldIsValidator.class)
public @interface RequireIfAnotherFieldIs {

  String require();

  String when();

  String is();

  String message() default
      "{com.thomsonreuters.training.backend.validators.RequireIfAnotherFieldIs.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
