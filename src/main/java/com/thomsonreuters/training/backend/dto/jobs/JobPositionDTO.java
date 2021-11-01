package com.thomsonreuters.training.backend.dto.jobs;

public class JobPositionDTO {
  String id;
  String name;

  public JobPositionDTO(String id, String name) {
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
