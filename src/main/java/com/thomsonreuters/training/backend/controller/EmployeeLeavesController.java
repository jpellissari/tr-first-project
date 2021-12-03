package com.thomsonreuters.training.backend.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import com.thomsonreuters.training.backend.dto.employees.CreateEmployeeLeaveDTO;
import com.thomsonreuters.training.backend.dto.employees.EmployeeLeaveDTO;
import com.thomsonreuters.training.backend.dto.employees.SimplifiedEmployeeLeaveDTO;
import com.thomsonreuters.training.backend.mapper.employees.CreateEmployeeLeaveMapper;
import com.thomsonreuters.training.backend.mapper.employees.EmployeeLeaveMapper;
import com.thomsonreuters.training.backend.mapper.employees.SimplifiedEmployeeLeavesMapper;
import com.thomsonreuters.training.backend.model.EmployeeLeave;
import com.thomsonreuters.training.backend.service.EmployeeLeavesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin
@RestController
@RequestMapping("/leaves")
public class EmployeeLeavesController {
  @Autowired private EmployeeLeavesService employeeLeavesService;
  @Autowired private CreateEmployeeLeaveMapper createEmployeeLeaveMapper;
  @Autowired private SimplifiedEmployeeLeavesMapper simplifiedEmployeeLeavesMapper;
  @Autowired private EmployeeLeaveMapper employeeLeaveMapper;

  @GetMapping
  public List<SimplifiedEmployeeLeaveDTO> index() {
    return simplifiedEmployeeLeavesMapper.toDto(employeeLeavesService.getAll());
  }

  @GetMapping("/{id}")
  public EmployeeLeaveDTO get(@PathVariable String id) {
    EmployeeLeave leave = employeeLeavesService.get(UUID.fromString(id));

    return employeeLeaveMapper.toDto(leave);
  }

  @PostMapping
  public ResponseEntity<Object> create(
      @RequestBody @Validated CreateEmployeeLeaveDTO data,
      UriComponentsBuilder uriComponentsBuilder) {
    EmployeeLeave employeeLeave =
        employeeLeavesService.create(createEmployeeLeaveMapper.toEntity(data));

    URI uri =
        uriComponentsBuilder
            .path("/leaves/{id}")
            .buildAndExpand(employeeLeave.getIdentifier().toString())
            .toUri();

    return ResponseEntity.created(uri).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> destroy(@PathVariable String id) {
    employeeLeavesService.delete(UUID.fromString(id));

    return ResponseEntity.noContent().build();
  }
}
