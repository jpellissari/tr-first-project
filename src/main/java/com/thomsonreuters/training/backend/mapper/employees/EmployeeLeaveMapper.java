package com.thomsonreuters.training.backend.mapper.employees;

import java.time.format.DateTimeFormatter;
import com.thomsonreuters.training.backend.dto.employees.EmployeeLeaveDTO;
import com.thomsonreuters.training.backend.mapper.clients.ClientMapper;
import com.thomsonreuters.training.backend.model.EmployeeLeave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeLeaveMapper {
  @Autowired private ClientMapper clientMapper;
  @Autowired private EmployeeMapper employeeMapper;

  public EmployeeLeaveDTO toDto(EmployeeLeave leave) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    EmployeeLeaveDTO dto = new EmployeeLeaveDTO();

    dto.setId(leave.getIdentifier().toString());
    dto.setClient(clientMapper.toDto(leave.getClient()));
    dto.setEmployee(employeeMapper.toDto(leave.getEmployee()));
    dto.setLeaveType(leave.getLeaveType().getType());
    dto.setLeaveDate(leave.getLeaveDate().format(formatter));
    dto.setNumberDays(leave.getNumberDays());
    if (leave.getReturnDate() != null) {
      dto.setReturnDate(leave.getReturnDate().format(formatter));
    }
    if (leave.getType() != null) {
      dto.setType(leave.getType().toString());
    }

    return dto;
  }
}
