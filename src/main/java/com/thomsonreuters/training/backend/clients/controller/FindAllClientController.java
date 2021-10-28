package com.thomsonreuters.training.backend.clients.controller;

import java.util.List;
import com.thomsonreuters.training.backend.clients.service.FindAllClientService;
import com.thomsonreuters.training.backend.clients.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindAllClientController {
  @Autowired
  private FindAllClientService findAllClientService;

  @GetMapping("/clients")
  public ResponseEntity<List<Client>> handle() {
    return ResponseEntity.ok().body(findAllClientService.execute());
  }
}
