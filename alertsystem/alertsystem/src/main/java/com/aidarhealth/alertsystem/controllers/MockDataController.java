package com.aidarhealth.alertsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aidarhealth.alertsystem.dto.PatientDataDTO;
import com.aidarhealth.alertsystem.repositories.ThresholdRepository;
import com.aidarhealth.alertsystem.services.AlertService;
import com.aidarhealth.alertsystem.services.PatientDataSimulator;

@RestController
@RequestMapping("/api")
public class MockDataController {

    @Autowired
    private PatientDataSimulator patientDataSimulator;
    @Autowired
    private AlertService alertService;
    @Autowired
    private ThresholdRepository thresholdRepository;
    // Endpoint to change the patientId used for mock data generation
    @PostMapping("mockdata/set-patient-id")
    public ResponseEntity<String> setMockPatientId(@RequestParam String patientId) {
        if (thresholdRepository.existsByPatientId(patientId)) {  // Check if patient exists
            patientDataSimulator.setPatientId(patientId);
            return ResponseEntity.ok("Mock Patient ID changed to " + patientId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Error: Patient ID " + patientId + " does not exist.");
        }
    }
    @GetMapping("/mock-data")
    public ResponseEntity<PatientDataDTO> getMockData() {
        PatientDataDTO mockData = alertService.getLatestMockData();  // Implementation of this in AlertService
        return ResponseEntity.ok(mockData);
    }
}

