package com.aidarhealth.alertsystem.services;

import com.aidarhealth.alertsystem.dto.ThresholdDto;
import com.aidarhealth.alertsystem.models.Threshold;
import com.aidarhealth.alertsystem.repositories.ThresholdRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThresholdService {

    @Autowired
    private ThresholdRepository thresholdRepository;

    // Save new thresholds for a patient
    
    
    public Threshold saveThresholds(ThresholdDto dto) {
        // Create a new Threshold object and map the fields
        Threshold threshold = new Threshold();
        threshold.setPatientId(dto.getPatientId());

        // Map heart rate thresholds if present
        if (dto.getHeartRate() != null) {
            threshold.setHeartRateMin(dto.getHeartRate().getMin());
            threshold.setHeartRateMax(dto.getHeartRate().getMax());
        }

        // Map blood pressure thresholds if present
        if (dto.getBloodPressure() != null) {
            threshold.setBloodPressureMin(dto.getBloodPressure().getMin());
            threshold.setBloodPressureMax(dto.getBloodPressure().getMax());
        }

        // Map temperature thresholds if present
        if (dto.getTemperature() != null) {
            threshold.setTemperatureMin(dto.getTemperature().getMin());
            threshold.setTemperatureMax(dto.getTemperature().getMax());
        }

        // Save the threshold entity to the database
        return thresholdRepository.save(threshold);
    }

    // Fetch all thresholds for a specific patient
    public List<Threshold> getThresholdsByPatientId(String patientId) {
        return thresholdRepository.findByPatientId(patientId);
    }

    // Get all thresholds (optional for debugging or admin view)
    public List<Threshold> getAllThresholds() {
        return thresholdRepository.findAll();
    }
}
