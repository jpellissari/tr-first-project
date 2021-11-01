package com.thomsonreuters.training.backend.dtos.clients;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class CreateClientDTO {
  @NotEmpty
  @Length(max = 60)
  String name;

  public String getName() {
    return name;
  }
}
