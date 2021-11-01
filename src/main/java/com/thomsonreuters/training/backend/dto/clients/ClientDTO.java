package com.thomsonreuters.training.backend.dto.clients;

public class ClientDTO {
  String id;
  String name;

  public ClientDTO(String name) {
    this.name = name;
  }

  public ClientDTO(String id, String name) {
    this.id = id;
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
