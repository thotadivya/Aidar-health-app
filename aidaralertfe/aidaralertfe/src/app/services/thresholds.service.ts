import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ThresholdsService {
  
  private apiUrl = 'http://localhost:8080/api/thresholds';

  constructor(private http: HttpClient) {}

  // Set thresholds
  setThresholds(thresholds: any): Observable<any> {
    return this.http.post(this.apiUrl, thresholds, { responseType: 'text' });
   
  }

  // Get thresholds by patientId
  getThresholds(patientId: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/${patientId}`);
  }
}
