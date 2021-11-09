package com.thomsonreuters.training.backend.model;

import java.time.LocalDate;

public interface LeaveType {
  LocalDate calculateReturnDate(LocalDate leaveDate);
}
