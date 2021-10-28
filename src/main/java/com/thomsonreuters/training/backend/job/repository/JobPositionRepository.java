package com.thomsonreuters.training.backend.job.repository;

import java.util.UUID;
import com.thomsonreuters.training.backend.job.entity.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionRepository extends JpaRepository<JobPosition, UUID> { }
