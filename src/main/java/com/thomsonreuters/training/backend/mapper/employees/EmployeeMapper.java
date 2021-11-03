package com.thomsonreuters.training.backend.mapper.employees;

import java.time.format.DateTimeFormatter;
import com.thomsonreuters.training.backend.dto.employees.EmployeeDTO;
import com.thomsonreuters.training.backend.mapper.clients.ClientMapper;
import com.thomsonreuters.training.backend.mapper.jobs.JobPositionMapper;
import com.thomsonreuters.training.backend.model.Employee;
import br.com.caelum.stella.format.CPFFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
  @Autowired private ClientMapper clientMapper;
  @Autowired private JobPositionMapper jobPositionMapper;

  public EmployeeDTO toDto(Employee employee) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    CPFFormatter cpfFormatter = new CPFFormatter();
    EmployeeDTO employeeDto = new EmployeeDTO();

    employeeDto.setId(employee.getIdentifier().toString());
    employeeDto.setName(employee.getName());
    employeeDto.setClient(clientMapper.toDto(employee.getClient()));
    employeeDto.setJobPosition(jobPositionMapper.toDto(employee.getJobPosition()));
    employeeDto.setName(employee.getName());
    employeeDto.setNationalIdentity(cpfFormatter.format(employee.getNationalIdentity()));
    employeeDto.setBirthdate(employee.getBirthdate().format(dateTimeFormatter));
    employeeDto.setActive(employee.isActive());
    employeeDto.setSalary(employee.getSalary());
    employeeDto.setType(employee.getType().toString());

    return employeeDto;
  }
}
