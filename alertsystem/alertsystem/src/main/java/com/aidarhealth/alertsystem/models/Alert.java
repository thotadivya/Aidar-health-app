package com.aidarhealth.alertsystem.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alerts")
public class Alert {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String patientId;
    private String metricName;
    private Double outOfRangeValue;
    private Boolean isReviewed = false; // Default is false
    private LocalDateTime alertTime;

    public Alert() {}

    public Alert(String patientId, String metricName, Double outOfRangeValue) {
        this.patientId = patientId;
        this.metricName = metricName;
        this.outOfRangeValue = outOfRangeValue;
        this.alertTime = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public Double getOutOfRangeValue() {
        return outOfRangeValue;
    }

    public void setOutOfRangeValue(Double outOfRangeValue) {
        this.outOfRangeValue = outOfRangeValue;
    }

    public Boolean getIsReviewed() {
        return isReviewed;
    }

    public void setIsReviewed(Boolean isReviewed) {
        this.isReviewed = isReviewed;
    }

    public LocalDateTime getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(LocalDateTime alertTime) {
        this.alertTime = alertTime;
    }
}
