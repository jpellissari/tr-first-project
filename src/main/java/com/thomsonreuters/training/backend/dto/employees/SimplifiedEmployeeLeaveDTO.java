package com.thomsonreuters.training.backend.dto.employees;

public class SimplifiedEmployeeLeaveDTO {
  private String id;
  private String clientId;
  private String employeeId;
  private String leaveType;
  private String leaveDate;
  private Integer numberDays;
  private String returnDate;
  private String type;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public String getLeaveType() {
    return leaveType;
  }

  public void setLeaveType(String leaveType) {
    this.leaveType = leaveType;
  }

  public String getLeaveDate() {
    return leaveDate;
  }

  public void setLeaveDate(String leaveDate) {
    this.leaveDate = leaveDate;
  }

  public Integer getNumberDays() {
    return numberDays;
  }

  public void setNumberDays(Integer numberDays) {
    this.numberDays = numberDays;
  }

  public String getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(String returnDate) {
    this.returnDate = returnDate;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
