package com.aidarhealth.alertsystem.dto;

public class ThresholdDto {
    private String patientId;
    private Range heartRate;
    private Range bloodPressure;
    private Range temperature;

    public static class Range {
        private double min;
        private double max;

        // Getters and Setters
        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min;
        }

        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max;
        }
    }

    // Getters and Setters
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Range getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Range heartRate) {
        this.heartRate = heartRate;
    }

    public Range getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Range bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Range getTemperature() {
        return temperature;
    }

    public void setTemperature(Range temperature) {
        this.temperature = temperature;
    }
}
