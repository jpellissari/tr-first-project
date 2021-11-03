package com.thomsonreuters.training.backend.model;

import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "\"Employee\"", schema = "public")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID identifier;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;

  @ManyToOne
  @JoinColumn(name = "job_position_id")
  private JobPosition jobPosition;

  @Column(name = "national_identity")
  private String nationalIdentity;

  @Enumerated(EnumType.STRING)
  private EmployeeTypes type;

  private String name;
  private LocalDate birthdate;

  @ColumnDefault("true")
  private boolean active;

  private double salary;

  public Employee() {}

  public Employee(
      Client client,
      JobPosition jobPosition,
      String name,
      String nationalIdentity,
      LocalDate birthdate,
      double salary,
      EmployeeTypes type) {
    this.client = client;
    this.jobPosition = jobPosition;
    this.name = name;
    this.nationalIdentity = nationalIdentity;
    this.birthdate = birthdate;
    this.salary = salary;
    this.active = true;
    this.type = type;
  }

  public UUID getIdentifier() {
    return identifier;
  }

  public Client getClient() {
    return client;
  }

  public JobPosition getJobPosition() {
    return jobPosition;
  }

  public String getName() {
    return name;
  }

  public String getNationalIdentity() {
    return nationalIdentity;
  }

  public LocalDate getBirthdate() {
    return birthdate;
  }

  public boolean isActive() {
    return active;
  }

  public double getSalary() {
    return salary;
  }

  public EmployeeTypes getType() {
    return type;
  }
}
