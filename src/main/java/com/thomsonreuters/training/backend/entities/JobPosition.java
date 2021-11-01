package com.thomsonreuters.training.backend.entities;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"JobPosition\"")
public class JobPosition {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID identifier;

  private String name;

  public JobPosition() {}

  public JobPosition(String name) {
    this.name = name;
  }

  public JobPosition(UUID identifier, String name) {
    this.identifier = identifier;
    this.name = name;
  }

  public UUID getIdentifier() {
    return identifier;
  }

  public String getName() {
    return name;
  }
}
