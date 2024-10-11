package com.aidarhealth.alertsystem.controllers;

import com.aidarhealth.alertsystem.dto.ThresholdDto;
import com.aidarhealth.alertsystem.models.Threshold;
import com.aidarhealth.alertsystem.services.ThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ThresholdController {

    @Autowired
    private ThresholdService thresholdService;

    // API to set thresholds for a specific patient
    
    @PostMapping("/thresholds")
    public ResponseEntity<String> setThresholds(@RequestBody ThresholdDto thresholds) {
        // Process the incoming thresholds data and save them
        Threshold savedThreshold = thresholdService.saveThresholds(thresholds);

        if (savedThreshold != null) {
            return ResponseEntity.ok("Thresholds saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save thresholds");
        }
    }

    // API to fetch thresholds by patientId
    @GetMapping("/thresholds/{patientId}")
    public List<Threshold> getThresholds(@PathVariable String patientId) {
        return thresholdService.getThresholdsByPatientId(patientId);
    }

    // Optional: Get all thresholds (for debugging or admin use)
    @GetMapping("/thresholds")
    public List<Threshold> getAllThresholds() {
        return thresholdService.getAllThresholds();
    }
}
