package com.thomsonreuters.training.backend.model.leavetypes;

import java.time.LocalDate;

public interface LeaveType {
  Integer getNumberOfDays();

  LocalDate calculateReturnDate(LocalDate leaveDate);
}
