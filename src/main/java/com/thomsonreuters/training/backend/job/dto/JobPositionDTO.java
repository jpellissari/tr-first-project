package com.thomsonreuters.training.backend.job.dto;

public class JobPositionDTO {
  String id;
  String name;

  public JobPositionDTO(String name) {
    this.name = name;
  }

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

  public void setId(String id) {
    this.id = id;
  }
}
