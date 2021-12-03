package com.thomsonreuters.training.backend.mapper.employees;

import com.thomsonreuters.training.backend.dto.employees.SimplifiedEmployeeDTO;
import com.thomsonreuters.training.backend.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class SimplifiedEmployeeMapper {
  public SimplifiedEmployeeDTO toDto(Employee employee) {
    return new SimplifiedEmployeeDTO(employee.getIdentifier().toString(), employee.getName());
  }
}
