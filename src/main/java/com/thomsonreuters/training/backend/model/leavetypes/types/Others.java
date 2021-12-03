package com.thomsonreuters.training.backend.model.leavetypes.types;

import java.time.LocalDate;
import com.thomsonreuters.training.backend.model.leavetypes.LeaveType;

public class Others implements LeaveType {

  @Override
  public Integer getNumberOfDays() {
    return null;
  }

  @Override
  public LocalDate calculateReturnDate(LocalDate leaveDate) {
    return null;
  }
}
