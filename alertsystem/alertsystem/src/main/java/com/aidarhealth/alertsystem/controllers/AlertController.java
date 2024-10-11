package com.aidarhealth.alertsystem.controllers;

import com.aidarhealth.alertsystem.dto.PatientDataDTO;
import com.aidarhealth.alertsystem.models.Alert;
import com.aidarhealth.alertsystem.services.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AlertController {

    @Autowired
    private AlertService alertService;

    // API to receive patient data and generate alerts if needed
    @PostMapping("/alerts")
    public ResponseEntity<List<Alert>> processPatientData(@RequestBody PatientDataDTO patientData) {
        List<Alert> alerts = alertService.processPatientData(patientData);
        return ResponseEntity.ok(alerts);
    }
    // API to get all alerts
    @GetMapping("/alerts")
    public ResponseEntity<List<Alert>> getAllAlerts() {
        List<Alert> alerts = alertService.getAllAlerts(); 
        return ResponseEntity.ok(alerts);
    }
    // API to get unreviewed alerts for a specific patient
    @GetMapping("/alerts/{patientId}")
    public ResponseEntity<List<Alert>> getUnreviewedAlerts(@PathVariable String patientId) {
        List<Alert> alerts = alertService.getUnreviewedAlerts(patientId);
        return ResponseEntity.ok(alerts);
    }
    @PutMapping("/alerts/{alertId}/review")
    public ResponseEntity<Void> markAlertAsReviewed(@PathVariable Long alertId) {
        alertService.markAlertAsReviewed(alertId);
        return ResponseEntity.ok().build();
    }

}
