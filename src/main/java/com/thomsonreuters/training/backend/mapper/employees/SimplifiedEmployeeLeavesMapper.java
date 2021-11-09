package com.thomsonreuters.training.backend.mapper.employees;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import com.thomsonreuters.training.backend.dto.employees.SimplifiedEmployeeLeaveDTO;
import com.thomsonreuters.training.backend.model.EmployeeLeave;
import org.springframework.stereotype.Component;

@Component
public class SimplifiedEmployeeLeavesMapper {
  public SimplifiedEmployeeLeaveDTO toDto(EmployeeLeave leave) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    SimplifiedEmployeeLeaveDTO simplifiedEmployeeLeave = new SimplifiedEmployeeLeaveDTO();

    simplifiedEmployeeLeave.setId(leave.getIdentifier().toString());
    simplifiedEmployeeLeave.setClientId(leave.getClient().getIdentifier().toString());
    simplifiedEmployeeLeave.setEmployeeId(leave.getEmployee().getIdentifier().toString());
    simplifiedEmployeeLeave.setLeaveType(leave.getLeaveType().toString());
    simplifiedEmployeeLeave.setLeaveDate(leave.getLeaveDate().format(formatter));
    simplifiedEmployeeLeave.setNumberDays(leave.getNumberDays());
    if (leave.getReturnDate() != null) {
      simplifiedEmployeeLeave.setReturnDate(leave.getReturnDate().format(formatter));
    }
    if (leave.getType() != null) {
      simplifiedEmployeeLeave.setType(leave.getType().toString());
    }

    return simplifiedEmployeeLeave;
  }

  public List<SimplifiedEmployeeLeaveDTO> toDto(List<EmployeeLeave> leaves) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    return leaves.stream()
        .map(
            leave -> {
              SimplifiedEmployeeLeaveDTO simplifiedEmployeeLeave = new SimplifiedEmployeeLeaveDTO();

              simplifiedEmployeeLeave.setId(leave.getIdentifier().toString());
              simplifiedEmployeeLeave.setClientId(leave.getClient().getIdentifier().toString());
              simplifiedEmployeeLeave.setEmployeeId(leave.getEmployee().getIdentifier().toString());
              simplifiedEmployeeLeave.setLeaveType(leave.getLeaveType().toString());
              simplifiedEmployeeLeave.setLeaveDate(leave.getLeaveDate().format(formatter));
              simplifiedEmployeeLeave.setNumberDays(leave.getNumberDays());
              if (leave.getReturnDate() != null) {
                simplifiedEmployeeLeave.setReturnDate(leave.getReturnDate().format(formatter));
              }
              if (leave.getType() != null) {
                simplifiedEmployeeLeave.setType(leave.getType().toString());
              }

              return simplifiedEmployeeLeave;
            })
        .collect(Collectors.toList());
  }
}
