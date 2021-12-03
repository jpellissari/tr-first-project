package com.thomsonreuters.training.backend.model.leavetypes.types;

import java.time.LocalDate;
import com.thomsonreuters.training.backend.model.leavetypes.LeaveType;

public class Vacation implements LeaveType {
  private final Integer numberOfDays;

  public Vacation(Integer numberOfDays) {
    this.numberOfDays = numberOfDays;
  }

  @Override
  public Integer getNumberOfDays() {
    return numberOfDays;
  }

  @Override
  public LocalDate calculateReturnDate(LocalDate leaveDate) {
    return leaveDate.plusDays(this.numberOfDays);
  }
}
