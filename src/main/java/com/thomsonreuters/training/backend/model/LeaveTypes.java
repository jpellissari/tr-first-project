package com.thomsonreuters.training.backend.model;

import java.time.LocalDate;

public enum LeaveTypes implements LeaveType {
  CONTRIBUTORS_DEATH("contributors_death", null),
  MATERNITY_LEAVE("maternity_leave", 180),
  PATERNITY_LEAVE("paternity_leave", 20),
  WORK_INJURY("work_injury", null),
  VACATION("vacation", null),
  TERMINATION("termination", null),
  OTHERS("others", null);

  private final Integer numberOfDays;
  private final String type;

  LeaveTypes(String type, Integer numberOfDays) {
    this.type = type;
    this.numberOfDays = numberOfDays;
  }

  public String getType() {
    return this.type;
  }

  public Integer getNumberOfDays() {
    return this.numberOfDays;
  }

  public LocalDate calculateReturnDate(LocalDate leaveDate) {
    return (this.numberOfDays == null) ? null : leaveDate.plusDays(this.numberOfDays);
  }
}
