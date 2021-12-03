package com.thomsonreuters.training.backend.model.leavetypes.types;

import java.time.LocalDate;
import com.thomsonreuters.training.backend.model.leavetypes.LeaveType;

public class PaternityLeave implements LeaveType {
  private static final Integer NUMBER_OF_DAYS = 20;

  @Override
  public Integer getNumberOfDays() {
    return NUMBER_OF_DAYS;
  }

  @Override
  public LocalDate calculateReturnDate(LocalDate leaveDate) {
    return leaveDate.plusDays(NUMBER_OF_DAYS);
  }
}
