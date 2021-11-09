package com.thomsonreuters.training.backend.controller;

import java.net.URI;
import java.util.List;
import com.thomsonreuters.training.backend.dto.employees.CreateEmployeeLeaveDTO;
import com.thomsonreuters.training.backend.dto.employees.SimplifiedEmployeeLeaveDTO;
import com.thomsonreuters.training.backend.mapper.employees.CreateEmployeeLeaveMapper;
import com.thomsonreuters.training.backend.mapper.employees.SimplifiedEmployeeLeavesMapper;
import com.thomsonreuters.training.backend.model.EmployeeLeave;
import com.thomsonreuters.training.backend.service.EmployeeLeavesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/leaves")
public class EmployeeLeavesController {
  @Autowired EmployeeLeavesService employeeLeavesService;
  @Autowired CreateEmployeeLeaveMapper createEmployeeLeaveMapper;
  @Autowired SimplifiedEmployeeLeavesMapper simplifiedEmployeeLeavesMapper;

  @GetMapping
  public List<SimplifiedEmployeeLeaveDTO> index() {
    return simplifiedEmployeeLeavesMapper.toDto(employeeLeavesService.getAll());
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
}
