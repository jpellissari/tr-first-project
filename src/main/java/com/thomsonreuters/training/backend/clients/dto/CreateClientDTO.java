package com.thomsonreuters.training.backend.clients.dto;

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
