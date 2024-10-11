import { Component, ViewChild } from '@angular/core';
import { ThresholdsService } from '../services/thresholds.service';
import { NgForm } from '@angular/forms';  // Import NgForm

@Component({
  selector: 'app-thresholds',
  templateUrl: './thresholds.component.html',
  styleUrls: ['./thresholds.component.css']
})
export class ThresholdsComponent {
  
  thresholds = {
    patientId: '',
    heartRate: { min: 0, max: 0 },
    bloodPressure: { min: 0, max: 0 },
    temperature: { min: 0, max: 0 }
  };

  @ViewChild('thresholdForm') thresholdForm!: NgForm;  // Reference the form

  constructor(private thresholdsService: ThresholdsService) {}

  setThresholds(): void {

    if (!this.isValidThresholds()) {
      alert('Please ensure all fields are valid before submitting.');
      return; // Stop submission if validation fails
    }
    
    // Submit and reset the form after success
    this.thresholdsService.setThresholds(this.thresholds).subscribe(() => {
      alert('Thresholds set successfully!');

      // Reset the form fields and validation
      this.thresholdForm.resetForm();  // Reset the form
    });
  }

  // Validation logic for the thresholds
  isValidThresholds(): boolean {
    return (
      this.thresholds.patientId !== '' &&
      this.thresholds.heartRate.min > 0 &&
      this.thresholds.heartRate.max > this.thresholds.heartRate.min &&
      this.thresholds.bloodPressure.min > 0 &&
      this.thresholds.bloodPressure.max > this.thresholds.bloodPressure.min &&
      this.thresholds.temperature.min > 0 &&
      this.thresholds.temperature.max > this.thresholds.temperature.min
    );
  }
}
