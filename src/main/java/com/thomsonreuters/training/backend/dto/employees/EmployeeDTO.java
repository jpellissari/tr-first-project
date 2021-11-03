package com.thomsonreuters.training.backend.dto.employees;

import com.thomsonreuters.training.backend.dto.clients.ClientDTO;
import com.thomsonreuters.training.backend.dto.jobs.JobPositionDTO;

public class EmployeeDTO {
  private String id;
  private ClientDTO client;
  private JobPositionDTO jobPosition;
  private String name;
  private String nationalIdentity;
  private String birthdate;
  private boolean active;
  private double salary;
  private String type;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ClientDTO getClient() {
    return client;
  }

  public void setClient(ClientDTO client) {
    this.client = client;
  }

  public JobPositionDTO getJobPosition() {
    return jobPosition;
  }

  public void setJobPosition(JobPositionDTO jobPosition) {
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

  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
