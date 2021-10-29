package com.thomsonreuters.training.backend.clients.repository;

import java.util.UUID;
import com.thomsonreuters.training.backend.clients.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, UUID> {}
