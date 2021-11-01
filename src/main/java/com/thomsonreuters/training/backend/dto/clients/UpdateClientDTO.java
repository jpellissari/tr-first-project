package com.thomsonreuters.training.backend.dto.clients;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class UpdateClientDTO {
  String id;

  @NotEmpty
  @Length(max = 60)
  String name;

  public UpdateClientDTO() {}

  public UpdateClientDTO(String name) {
    this.name = name;
  }

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
