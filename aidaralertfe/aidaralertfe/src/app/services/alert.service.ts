import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlertService {

  private apiUrl = 'http://localhost:8080/api/alerts';
  private mockDataUrl = 'http://localhost:8080/api/mock-data'; 
  constructor(private http: HttpClient) {}

  // Fetch all unreviewed alerts
  getAlerts(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

    // Fetch mock data from the backend
    getMockData(): Observable<any> {
      return this.http.get<any>(this.mockDataUrl);  // Make an API call to get the mock data
    }
  // Mark alert as reviewed
  markAsReviewed(alertId: number): Observable<any> {
    return this.http.put(`${this.apiUrl}/${alertId}/review`, {});
  }
}
