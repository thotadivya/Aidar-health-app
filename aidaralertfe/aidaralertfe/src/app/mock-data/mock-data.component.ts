import { Component, OnInit } from '@angular/core';
import { interval, Subscription } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { AlertService } from '../services/alert.service';

@Component({
  selector: 'app-mock-data',
  templateUrl: './mock-data.component.html',
  styleUrls: ['./mock-data.component.css']
})
export class MockDataComponent implements OnInit {
  heartRate: number = 0;
  bloodPressure: number = 0;
  temperature: number = 0;
  newPatientId: string = '';  // Field to hold new patient ID input
  loading: boolean = false;  // To indicate loading state
  pollingSubscription: Subscription | undefined;  // To manage polling subscription
  errorMessage: string | null = null;  
  successmessage: string | null = null; 
  constructor(private alertService: AlertService, private http: HttpClient) {}

  ngOnInit(): void {
    this.startPolling();
  }

  // Method to start polling mock data
  startPolling(): void {
    this.pollingSubscription = interval(5000).subscribe(() => {
      this.fetchMockData();
    });
  }

  // Fetch mock data from the backend
  fetchMockData(): void {
    this.loading = true;  // Start loading
    this.alertService.getMockData().subscribe(
      (data: any) => {
        this.heartRate = data.heartRate;
        this.bloodPressure = data.bloodPressure;
        this.temperature = data.temperature;
        this.loading = false;  // Stop loading when data is received
      },
      (error) => {
        console.error('Error fetching mock data:', error);
        this.loading = false;  // Stop loading on error
      }
    );
  }

  // Method to send new patient ID to the backend
  changePatientId(): void {
    if (this.newPatientId.trim()) {
      this.http.post('http://localhost:8080/api/mockdata/set-patient-id', null, {
        params: { patientId: this.newPatientId },
        responseType: 'text' 
      }).subscribe(
        response => {
          this.errorMessage = null;
          this.successmessage = 'Patient ID changed successfully to ' + this.newPatientId;
          this.fetchMockData();  // Fetch updated mock data for the new patient ID
        },
        error => {
          this.successmessage = null;
          console.error('Error changing patient ID:', error);
          this.errorMessage = 'Patient doesnot exist.';
        }
      );
    } else {
      alert('Please enter a valid patient ID');
    }
  }

  // Optional: Clean up polling subscription to avoid memory leaks
  ngOnDestroy(): void {
    if (this.pollingSubscription) {
      this.pollingSubscription.unsubscribe();
    }
  }
}
