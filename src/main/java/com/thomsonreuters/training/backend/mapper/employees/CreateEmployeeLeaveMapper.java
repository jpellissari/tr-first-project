package com.thomsonreuters.training.backend.mapper.employees;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import com.thomsonreuters.training.backend.dto.employees.CreateEmployeeLeaveDTO;
import com.thomsonreuters.training.backend.exception.ClientNotFoundException;
import com.thomsonreuters.training.backend.exception.EmployeeNotFoundException;
import com.thomsonreuters.training.backend.model.Client;
import com.thomsonreuters.training.backend.model.Employee;
import com.thomsonreuters.training.backend.model.EmployeeLeave;
import com.thomsonreuters.training.backend.model.EmployeeLeaveTypes;
import com.thomsonreuters.training.backend.model.LeaveTypes;
import com.thomsonreuters.training.backend.repository.ClientsRepository;
import com.thomsonreuters.training.backend.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateEmployeeLeaveMapper {
  @Autowired private ClientsRepository clientsRepository;
  @Autowired private EmployeesRepository employeesRepository;

  public EmployeeLeave toEntity(CreateEmployeeLeaveDTO data) {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    Client client =
        clientsRepository
            .findById(UUID.fromString(data.getClientId()))
            .orElseThrow(ClientNotFoundException::new);
    Employee employee =
        employeesRepository
            .findById(UUID.fromString(data.getEmployeeId()))
            .orElseThrow(EmployeeNotFoundException::new);

    EmployeeLeave employeeLeave = new EmployeeLeave();

    employeeLeave.setClient(client);
    employeeLeave.setEmployee(employee);
    employeeLeave.setLeaveType(LeaveTypes.valueOf(data.getLeaveType().toUpperCase()));
    employeeLeave.setLeaveDate(LocalDate.parse(data.getLeaveDate(), dateFormatter));
    if (data.getLeaveType().equals("vacation")) {
      employeeLeave.setNumberDays(data.getNumberDays());
    }
    if (data.getLeaveType().equals("work_injury")) {
      employeeLeave.setType(EmployeeLeaveTypes.valueOf(data.getType().toUpperCase()));
    }

    return employeeLeave;
  }
}
