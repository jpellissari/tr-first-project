package com.thomsonreuters.training.backend.dto.jobs;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.thomsonreuters.training.backend.validators.UUID;
import org.hibernate.validator.constraints.Length;

public class UpdateJobPositionDTO {
  @NotNull @UUID String id;

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
