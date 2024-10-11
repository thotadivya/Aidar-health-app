package com.aidarhealth.alertsystem.repositories;

import com.aidarhealth.alertsystem.dto.ThresholdDto;
import com.aidarhealth.alertsystem.models.Threshold;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThresholdRepository extends JpaRepository<Threshold, Long> {
    List<Threshold> findByPatientId(String patientId);
    boolean existsByPatientId(String patientId);
	
}
