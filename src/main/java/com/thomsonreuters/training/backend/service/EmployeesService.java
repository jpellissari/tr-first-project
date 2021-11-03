package com.thomsonreuters.training.backend.service;

import java.util.List;
import java.util.UUID;
import com.thomsonreuters.training.backend.exception.EmployeeAlreadyExistsException;
import com.thomsonreuters.training.backend.exception.EmployeeNotFoundException;
import com.thomsonreuters.training.backend.model.Employee;
import com.thomsonreuters.training.backend.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeesService {
  @Autowired private EmployeesRepository employeesRepository;

  public List<Employee> getAll() {
    return employeesRepository.findAll();
  }

  public Employee get(UUID id) {
    return employeesRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
  }

  public Employee create(Employee employee) {
    if (this.employeesRepository
        .findByNationalIdentityAndClientIdentifier(
            employee.getNationalIdentity(), employee.getClient().getIdentifier())
        .isPresent()) {
      throw new EmployeeAlreadyExistsException();
    }
    return employeesRepository.save(employee);
  }

  public Employee update(Employee client) {
    return employeesRepository
        .findById(client.getIdentifier())
        .orElseThrow(EmployeeNotFoundException::new);
  }

  public void delete(UUID id) {
    Employee employee =
        employeesRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);

    employeesRepository.delete(employee);
  }
}
