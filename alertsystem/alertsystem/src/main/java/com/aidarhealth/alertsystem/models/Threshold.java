package com.aidarhealth.alertsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "thresholds")
public class Threshold {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientId;

    // Heart Rate
    private Double heartRateMin;
    private Double heartRateMax;

    // Blood Pressure
    private Double bloodPressureMin;
    private Double bloodPressureMax;

    // Temperature
    private Double temperatureMin;
    private Double temperatureMax;

    // Default Constructor
    public Threshold() {
    }

    // Constructor with parameters
    public Threshold(String patientId, Double heartRateMin, Double heartRateMax, 
                     Double bloodPressureMin, Double bloodPressureMax, 
                     Double temperatureMin, Double temperatureMax) {
        this.patientId = patientId;
        this.heartRateMin = heartRateMin;
        this.heartRateMax = heartRateMax;
        this.bloodPressureMin = bloodPressureMin;
        this.bloodPressureMax = bloodPressureMax;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
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

    public Double getHeartRateMin() {
        return heartRateMin;
    }

    public void setHeartRateMin(Double heartRateMin) {
        this.heartRateMin = heartRateMin;
    }

    public Double getHeartRateMax() {
        return heartRateMax;
    }

    public void setHeartRateMax(Double heartRateMax) {
        this.heartRateMax = heartRateMax;
    }

    public Double getBloodPressureMin() {
        return bloodPressureMin;
    }

    public void setBloodPressureMin(Double bloodPressureMin) {
        this.bloodPressureMin = bloodPressureMin;
    }

    public Double getBloodPressureMax() {
        return bloodPressureMax;
    }

    public void setBloodPressureMax(Double bloodPressureMax) {
        this.bloodPressureMax = bloodPressureMax;
    }

    public Double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(Double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public Double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(Double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }
}
