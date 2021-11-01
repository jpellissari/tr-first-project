package com.thomsonreuters.training.backend.shared;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationErrorHandler {
  @Autowired private MessageSource messageSource;

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<ValidationErrorDTO> handle(MethodArgumentNotValidException exception) {
    List<ValidationErrorDTO> errors = new ArrayList<>();

    List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
    fieldErrors.forEach(
        e -> {
          String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
          ValidationErrorDTO error = new ValidationErrorDTO(e.getField(), message);
          errors.add(error);
        });

    return errors;
  }
}
