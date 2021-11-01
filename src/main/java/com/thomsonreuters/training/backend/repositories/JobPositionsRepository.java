package com.thomsonreuters.training.backend.repositories;

import java.util.UUID;
import com.thomsonreuters.training.backend.entities.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionsRepository extends JpaRepository<JobPosition, UUID> {}
