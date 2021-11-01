package com.thomsonreuters.training.backend.dtos.jobs;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class UpdateJobPositionDTO {
  String id;

  @NotEmpty
  @Length(max = 50)
  String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
}
