package com.thomsonreuters.training.backend.repository;

import java.util.UUID;
import com.thomsonreuters.training.backend.model.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionsRepository extends JpaRepository<JobPosition, UUID> {}
