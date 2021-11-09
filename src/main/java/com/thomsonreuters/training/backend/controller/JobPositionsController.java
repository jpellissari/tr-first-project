package com.thomsonreuters.training.backend.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import com.thomsonreuters.training.backend.dto.jobs.CreateJobPositionDTO;
import com.thomsonreuters.training.backend.dto.jobs.JobPositionDTO;
import com.thomsonreuters.training.backend.dto.jobs.UpdateJobPositionDTO;
import com.thomsonreuters.training.backend.mapper.jobs.CreateJobPositionMapper;
import com.thomsonreuters.training.backend.mapper.jobs.JobPositionMapper;
import com.thomsonreuters.training.backend.mapper.jobs.UpdateJobPositionMapper;
import com.thomsonreuters.training.backend.model.JobPosition;
import com.thomsonreuters.training.backend.service.JobPositionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/jobs")
public class JobPositionsController {
  @Autowired private JobPositionsService jobPositionsService;

  @Autowired private JobPositionMapper jobPositionMapper;
  @Autowired private CreateJobPositionMapper createJobPositionMapper;
  @Autowired private UpdateJobPositionMapper updateJobPositionMapper;

  @GetMapping
  public List<JobPositionDTO> index() {
    List<JobPosition> jobPositions = jobPositionsService.getAll();

    return jobPositions.stream()
        .map(jobPosition -> jobPositionMapper.toDto(jobPosition))
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public JobPositionDTO get(@PathVariable String id) {
    JobPosition jobPosition = jobPositionsService.get(UUID.fromString(id));

    return jobPositionMapper.toDto(jobPosition);
  }

  @PostMapping
  public ResponseEntity<Object> create(
      @RequestBody @Validated CreateJobPositionDTO data,
      UriComponentsBuilder uriComponentsBuilder) {
    JobPosition jobPosition = jobPositionsService.create(createJobPositionMapper.toEntity(data));

    URI uri =
        uriComponentsBuilder.path("/jobs/{id}").buildAndExpand(jobPosition.getIdentifier()).toUri();

    return ResponseEntity.created(uri).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> update(
      @PathVariable String id, @RequestBody @Validated UpdateJobPositionDTO data) {
    data.setId(id);
    JobPosition jobPosition = jobPositionsService.update(updateJobPositionMapper.toEntity(data));

    return ResponseEntity.ok(jobPositionMapper.toDto(jobPosition));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable String id) {
    jobPositionsService.delete(UUID.fromString(id));

    return ResponseEntity.status(204).build();
  }
}
