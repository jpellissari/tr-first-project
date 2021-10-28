package com.thomsonreuters.training.backend.clients.controller;

import java.util.UUID;
import com.thomsonreuters.training.backend.clients.entity.Client;
import com.thomsonreuters.training.backend.clients.service.ListOneClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListOneClientController {
  @Autowired
  private ListOneClientService listOneClientService;

  @GetMapping("/clients/{id}")
  public Client handle(@PathVariable UUID id) {
    return this.listOneClientService.execute(id);
  }
}
