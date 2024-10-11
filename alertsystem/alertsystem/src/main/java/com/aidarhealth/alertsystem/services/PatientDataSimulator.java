package com.aidarhealth.alertsystem.services;

import com.aidarhealth.alertsystem.dto.PatientDataDTO;
import com.aidarhealth.alertsystem.repositories.ThresholdRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PatientDataSimulator {

    @Autowired
    private AlertService alertService;
    @Autowired
    private ThresholdRepository thresholdRepository;
    // Add a field for the patient ID
    private String patientId = "17"; // Default patientId

    // Simulate patient data every 30 seconds
    @Scheduled(fixedRate = 30000)
    public void simulatePatientData() {
    	 if (thresholdRepository.existsByPatientId(this.patientId)) {
        Random random = new Random();

        // Create mock patient data
        PatientDataDTO mockData = new PatientDataDTO();
        mockData.setPatientId(this.patientId);  // Use the variable patientId here
        mockData.setHeartRate(60 + random.nextInt(40)); // Random heart rate between 60 and 100
        mockData.setBloodPressure(170 + random.nextInt(30)); // Random blood pressure between 120 and 150
        mockData.setTemperature(36.0 + random.nextDouble() * 2); // Random temperature between 36 and 38 degrees

        // Send this mock data to trigger alerts if needed
        alertService.processPatientData(mockData);
    }}

    // Setter method to change the patient ID dynamically
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
