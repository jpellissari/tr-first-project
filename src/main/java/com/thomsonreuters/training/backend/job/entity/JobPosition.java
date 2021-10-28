package com.thomsonreuters.training.backend.job.entity;

import java.util.UUID;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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

  public void setName(String name) {
    this.name = name;
  }
}
