package com.thomsonreuters.training.backend.mapper.employees;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import com.thomsonreuters.training.backend.dto.employees.UpdateEmployeeDTO;
import com.thomsonreuters.training.backend.exception.ClientNotFoundException;
import com.thomsonreuters.training.backend.exception.JobPositionNotFoundException;
import com.thomsonreuters.training.backend.model.Client;
import com.thomsonreuters.training.backend.model.Employee;
import com.thomsonreuters.training.backend.model.EmployeeTypes;
import com.thomsonreuters.training.backend.model.JobPosition;
import com.thomsonreuters.training.backend.repository.ClientsRepository;
import com.thomsonreuters.training.backend.repository.JobPositionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateEmployeeMapper {
  @Autowired private ClientsRepository clientsRepository;
  @Autowired private JobPositionsRepository jobPositionsRepository;

  public Employee toEntity(UpdateEmployeeDTO data) {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    Client client =
        this.clientsRepository
            .findById(UUID.fromString(data.getClientId()))
            .orElseThrow(ClientNotFoundException::new);
    JobPosition jobPosition =
        this.jobPositionsRepository
            .findById(UUID.fromString(data.getJobPositionId()))
            .orElseThrow(JobPositionNotFoundException::new);

    return new Employee(
        client,
        jobPosition,
        data.getName(),
        data.getNationalIdentity(),
        LocalDate.parse(data.getBirthdate(), dateFormatter),
        data.getSalary(),
        data.isActive(),
        EmployeeTypes.valueOf(data.getType().toUpperCase()));
  }
}
