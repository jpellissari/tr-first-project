package com.thomsonreuters.training.backend.dto.employees;

public class SimplifiedEmployeeDTO {
  private final String id;
  private final String name;

  public SimplifiedEmployeeDTO(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
