package com.thomsonreuters.training.backend.model;

import java.time.LocalDate;
import java.util.List;
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
import javax.persistence.OneToMany;
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

  @OneToMany(mappedBy = "employee")
  private List<EmployeeLeave> employeeLeaves;

  public Employee() {}

  public Employee(
      UUID identifier,
      Client client,
      JobPosition jobPosition,
      String name,
      String nationalIdentity,
      LocalDate birthdate,
      boolean active,
      double salary,
      EmployeeTypes type) {
    this(client, jobPosition, name, nationalIdentity, birthdate, salary, active, type);
    this.identifier = identifier;
  }

  public Employee(
      Client client,
      JobPosition jobPosition,
      String name,
      String nationalIdentity,
      LocalDate birthdate,
      double salary,
      boolean active,
      EmployeeTypes type) {
    this.client = client;
    this.jobPosition = jobPosition;
    this.name = name;
    this.nationalIdentity = nationalIdentity;
    this.birthdate = birthdate;
    this.salary = salary;
    this.active = active;
    this.type = type;
  }

  public List<EmployeeLeave> getEmployeeLeaves() {
    return employeeLeaves;
  }

  public void setEmployeeLeaves(List<EmployeeLeave> employeeLeaves) {
    this.employeeLeaves = employeeLeaves;
  }

  public UUID getIdentifier() {
    return identifier;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public JobPosition getJobPosition() {
    return jobPosition;
  }

  public void setJobPosition(JobPosition jobPosition) {
    this.jobPosition = jobPosition;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNationalIdentity() {
    return nationalIdentity;
  }

  public void setNationalIdentity(String nationalIdentity) {
    this.nationalIdentity = nationalIdentity;
  }

  public LocalDate getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public EmployeeTypes getType() {
    return type;
  }

  public void setType(EmployeeTypes type) {
    this.type = type;
  }
}
