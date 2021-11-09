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

  private boolean existsClientWithNationalIdentityWorkingOnClient(Employee employee) {
    return this.employeesRepository
        .findByNationalIdentityAndClientIdentifier(
            employee.getNationalIdentity(), employee.getClient().getIdentifier())
        .isPresent();
  }

  private boolean clientIdChanged(Employee oldEmployee, Employee newEmployee) {
    return !oldEmployee.getClient().equals(newEmployee.getClient());
  }

  public List<Employee> getAll() {
    return employeesRepository.findAll();
  }

  public Employee get(UUID id) {
    return employeesRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
  }

  public Employee create(Employee employee) {
    if (existsClientWithNationalIdentityWorkingOnClient(employee)) {
      throw new EmployeeAlreadyExistsException();
    }
    return employeesRepository.save(employee);
  }

  public Employee update(UUID id, Employee newEmployee) {
    Employee findEmployee =
        employeesRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);

    if (clientIdChanged(findEmployee, newEmployee)
        && existsClientWithNationalIdentityWorkingOnClient(newEmployee)) {
      throw new EmployeeAlreadyExistsException();
    }

    findEmployee.setActive(newEmployee.isActive());
    findEmployee.setBirthdate(newEmployee.getBirthdate());
    findEmployee.setClient(newEmployee.getClient());
    findEmployee.setJobPosition(newEmployee.getJobPosition());
    findEmployee.setName(newEmployee.getName());
    findEmployee.setSalary(newEmployee.getSalary());
    findEmployee.setType(newEmployee.getType());
    findEmployee.setNationalIdentity(newEmployee.getNationalIdentity());

    return employeesRepository.save(findEmployee);
  }

  public void delete(UUID id) {
    Employee employee =
        employeesRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);

    employeesRepository.delete(employee);
  }
}
