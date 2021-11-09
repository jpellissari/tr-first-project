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

@Entity
@Table(name = "\"EmployeeLeave\"", schema = "public")
public class EmployeeLeave {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID identifier;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;

  @ManyToOne
  @JoinColumn(name = "employee_id")
  private Employee employee;

  @Enumerated(EnumType.STRING)
  @Column(name = "leave_type")
  private LeaveTypes leaveType;

  @Column(name = "leave_date")
  private LocalDate leaveDate;

  @Column(name = "number_days")
  private Integer numberDays;

  @Column(name = "return_date")
  private LocalDate returnDate;

  @Enumerated(EnumType.STRING)
  private EmployeeLeaveTypes type;

  public EmployeeLeave() {}

  public EmployeeLeave(
      Client client,
      Employee employee,
      LeaveTypes leaveType,
      LocalDate leaveDate,
      Integer numberDays,
      LocalDate returnDate,
      EmployeeLeaveTypes type) {
    this.client = client;
    this.employee = employee;
    this.leaveType = leaveType;
    this.leaveDate = leaveDate;
    this.numberDays = numberDays;
    this.returnDate = returnDate;
    this.type = type;
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

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public LeaveTypes getLeaveType() {
    return leaveType;
  }

  public void setLeaveType(LeaveTypes leaveType) {
    this.leaveType = leaveType;
  }

  public LocalDate getLeaveDate() {
    return leaveDate;
  }

  public void setLeaveDate(LocalDate leaveDate) {
    this.leaveDate = leaveDate;
  }

  public Integer getNumberDays() {
    return numberDays;
  }

  public void setNumberDays(Integer numberDays) {
    this.numberDays = numberDays;
  }

  public LocalDate getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
  }

  public EmployeeLeaveTypes getType() {
    return type;
  }

  public void setType(EmployeeLeaveTypes type) {
    this.type = type;
  }
}
