package com.thomsonreuters.training.backend.service;

import java.util.List;
import java.util.UUID;
import com.thomsonreuters.training.backend.exception.EmployeeLeaveNotFoundException;
import com.thomsonreuters.training.backend.model.EmployeeLeave;

public interface EmployeeLeavesService {
  List<EmployeeLeave> getAll();

  EmployeeLeave get(UUID id) throws EmployeeLeaveNotFoundException;

  EmployeeLeave create(EmployeeLeave jobPosition);

  EmployeeLeave update(EmployeeLeave jobPosition);

  void delete(UUID id) throws EmployeeLeaveNotFoundException;
}
