package com.thomsonreuters.training.backend.clients.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"Client\"")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID identifier;
  private String name;

  public Client() {}

  public Client(String name) {
    this.name = name;
  }

  public Client(UUID identifier, String name) {
    this.identifier = identifier;
    this.name = name;
  }

  public UUID getIdentifier() {
    return identifier;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
