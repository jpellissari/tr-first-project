package com.thomsonreuters.training.backend.clients.dto;

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

  public String getName() {
    return name;
  }
}
