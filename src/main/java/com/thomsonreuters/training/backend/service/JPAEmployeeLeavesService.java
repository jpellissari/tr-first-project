package com.thomsonreuters.training.backend.service;

import static com.thomsonreuters.training.backend.model.LeaveTypes.CONTRIBUTORS_DEATH;
import static com.thomsonreuters.training.backend.model.LeaveTypes.TERMINATION;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.thomsonreuters.training.backend.exception.EmployeeCanNotHaveMoreLeavesException;
import com.thomsonreuters.training.backend.exception.EmployeeLeaveNotFoundException;
import com.thomsonreuters.training.backend.model.EmployeeLeave;
import com.thomsonreuters.training.backend.model.LeaveTypes;
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
    return null;
  }

  public EmployeeLeave create(EmployeeLeave employeeLeave) {
    List<LeaveTypes> forbiddenNewLeave = new ArrayList<>();
    forbiddenNewLeave.add(CONTRIBUTORS_DEATH);
    forbiddenNewLeave.add(TERMINATION);

    Optional<EmployeeLeave> leave =
        employeeLeavesRepository.findByEmployeeAndLeaveTypeIn(
            employeeLeave.getEmployee(), forbiddenNewLeave);

    if (leave.isPresent()) {
      throw new EmployeeCanNotHaveMoreLeavesException(leave.get().getLeaveType().toString());
    }

    switch (employeeLeave.getLeaveType()) {
      case PATERNITY_LEAVE:
        employeeLeave.setNumberDays(20);
        employeeLeave.setReturnDate(employeeLeave.getLeaveDate().plusDays(20));
        break;
      case MATERNITY_LEAVE:
        employeeLeave.setNumberDays(180);
        employeeLeave.setReturnDate(employeeLeave.getLeaveDate().plusDays(180));
        break;
      case VACATION:
        employeeLeave.setReturnDate(
            employeeLeave.getLeaveDate().plusDays(employeeLeave.getNumberDays()));
        break;
      default:
        break;
    }

    return employeeLeavesRepository.save(employeeLeave);
  }

  public EmployeeLeave update(EmployeeLeave jobPosition) {
    return null;
  }

  public void delete(UUID id) throws EmployeeLeaveNotFoundException {
    /* implement method */
  }
}
