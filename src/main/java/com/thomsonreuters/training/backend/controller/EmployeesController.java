package com.thomsonreuters.training.backend.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import com.thomsonreuters.training.backend.dto.employees.CreateEmployeeDTO;
import com.thomsonreuters.training.backend.dto.employees.EmployeeDTO;
import com.thomsonreuters.training.backend.mapper.employees.CreateEmployeeMapper;
import com.thomsonreuters.training.backend.mapper.employees.EmployeeMapper;
import com.thomsonreuters.training.backend.model.Employee;
import com.thomsonreuters.training.backend.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
  @Autowired private EmployeesService employeesService;
  @Autowired private EmployeeMapper employeeMapper;
  @Autowired private CreateEmployeeMapper createEmployeeMapper;

  @GetMapping
  public List<EmployeeDTO> index() {
    return employeesService.getAll().stream()
        .map(employee -> employeeMapper.toDto(employee))
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public EmployeeDTO get(@PathVariable String id) {
    Employee employee = employeesService.get(UUID.fromString(id));

    return employeeMapper.toDto(employee);
  }

  @PostMapping
  public ResponseEntity<Object> create(
      @RequestBody @Validated CreateEmployeeDTO data, UriComponentsBuilder uriComponentsBuilder) {
    Employee employee = employeesService.create(createEmployeeMapper.toEntity(data));

    URI uri =
        uriComponentsBuilder
            .path("/employees/{id}")
            .buildAndExpand(employee.getIdentifier().toString())
            .toUri();

    return ResponseEntity.created(uri).build();
  }
}
