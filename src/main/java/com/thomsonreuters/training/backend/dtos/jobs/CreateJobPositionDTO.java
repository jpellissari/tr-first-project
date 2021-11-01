package com.thomsonreuters.training.backend.dtos.jobs;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class CreateJobPositionDTO {
  @NotEmpty
  @Length(max = 50)
  String name;

  public String getName() {
    return name;
  }
}
