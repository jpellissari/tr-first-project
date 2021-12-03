package com.thomsonreuters.training.backend.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import com.thomsonreuters.training.backend.model.Employee;
import com.thomsonreuters.training.backend.model.EmployeeLeave;
import com.thomsonreuters.training.backend.model.leavetypes.LeaveTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeLeavesRepository extends JpaRepository<EmployeeLeave, UUID> {
  Optional<EmployeeLeave> findByEmployeeAndLeaveTypeIn(
      Employee employee, Collection<LeaveTypes> leaveTypes);
}
