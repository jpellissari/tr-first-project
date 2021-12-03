package com.thomsonreuters.training.backend.mapper.employees;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import com.thomsonreuters.training.backend.dto.employees.SimplifiedEmployeeLeaveDTO;
import com.thomsonreuters.training.backend.mapper.clients.ClientMapper;
import com.thomsonreuters.training.backend.model.EmployeeLeave;
import org.springframework.stereotype.Component;

@Component
public class SimplifiedEmployeeLeavesMapper {
  private final DateTimeFormatter formatter;
  private final ClientMapper clientMapper;
  private final SimplifiedEmployeeMapper simplifiedEmployeeMapper;

  public SimplifiedEmployeeLeavesMapper() {
    this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    this.clientMapper = new ClientMapper();
    this.simplifiedEmployeeMapper = new SimplifiedEmployeeMapper();
  }

  public SimplifiedEmployeeLeaveDTO toDto(EmployeeLeave leave) {
    SimplifiedEmployeeLeaveDTO simplifiedEmployeeLeave = new SimplifiedEmployeeLeaveDTO();

    simplifiedEmployeeLeave.setId(leave.getIdentifier().toString());
    simplifiedEmployeeLeave.setClient(clientMapper.toDto(leave.getClient()));
    simplifiedEmployeeLeave.setEmployee(simplifiedEmployeeMapper.toDto(leave.getEmployee()));
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
    return leaves.stream()
        .map(
            leave -> {
              SimplifiedEmployeeLeaveDTO simplifiedEmployeeLeave = new SimplifiedEmployeeLeaveDTO();

              simplifiedEmployeeLeave.setId(leave.getIdentifier().toString());
              simplifiedEmployeeLeave.setClient(clientMapper.toDto(leave.getClient()));
              simplifiedEmployeeLeave.setEmployee(
                  simplifiedEmployeeMapper.toDto(leave.getEmployee()));
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
