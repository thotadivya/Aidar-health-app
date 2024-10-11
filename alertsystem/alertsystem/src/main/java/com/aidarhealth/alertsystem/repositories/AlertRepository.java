package com.aidarhealth.alertsystem.repositories;

import com.aidarhealth.alertsystem.models.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findByPatientIdAndIsReviewedFalse(String patientId);
}
