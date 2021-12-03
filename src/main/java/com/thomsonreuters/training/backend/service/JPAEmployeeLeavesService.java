package com.thomsonreuters.training.backend.service;

import static com.thomsonreuters.training.backend.model.leavetypes.LeaveTypes.CONTRIBUTORS_DEATH;
import static com.thomsonreuters.training.backend.model.leavetypes.LeaveTypes.TERMINATION;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.thomsonreuters.training.backend.exception.EmployeeCanNotHaveMoreLeavesException;
import com.thomsonreuters.training.backend.exception.EmployeeLeaveNotFoundException;
import com.thomsonreuters.training.backend.model.EmployeeLeave;
import com.thomsonreuters.training.backend.model.leavetypes.LeaveType;
import com.thomsonreuters.training.backend.repository.EmployeeLeavesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JPAEmployeeLeavesService implements EmployeeLeavesService {
  @Autowired private EmployeeLeavesRepository employeeLeavesRepository;

  public List<EmployeeLeave> getAll() {
    return employeeLeavesRepository.findAll();
  }

  public EmployeeLeave get(UUID id) throws EmployeeLeaveNotFoundException {
    return employeeLeavesRepository.findById(id).orElseThrow(EmployeeLeaveNotFoundException::new);
  }

  public EmployeeLeave create(EmployeeLeave employeeLeave) {
    verifyIfUserCanHaveAnotherLeave(employeeLeave);

    LeaveType leaveType = employeeLeave.getLeaveType().getInstance(employeeLeave.getNumberDays());
    employeeLeave.setNumberDays(leaveType.getNumberOfDays());
    employeeLeave.setReturnDate(leaveType.calculateReturnDate(employeeLeave.getLeaveDate()));

    return employeeLeavesRepository.save(employeeLeave);
  }

  private void verifyIfUserCanHaveAnotherLeave(EmployeeLeave employeeLeave) {
    Optional<EmployeeLeave> leave =
        employeeLeavesRepository.findByEmployeeAndLeaveTypeIn(
            employeeLeave.getEmployee(), List.of(CONTRIBUTORS_DEATH, TERMINATION));

    if (leave.isPresent()) {
      throw new EmployeeCanNotHaveMoreLeavesException(leave.get().getLeaveType().toString());
    }
  }

  public EmployeeLeave update(EmployeeLeave jobPosition) {
    return null;
  }

  public void delete(UUID id) throws EmployeeLeaveNotFoundException {
    EmployeeLeave leave =
        employeeLeavesRepository.findById(id).orElseThrow(EmployeeLeaveNotFoundException::new);

    employeeLeavesRepository.delete(leave);
  }
}
