import { Component, OnInit } from '@angular/core';
import { AlertService } from '../services/alert.service';
import { interval } from 'rxjs';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css']
})
export class AlertComponent implements OnInit {
  alerts: any[] = [];
  unreviewedAlertCount: number = 0;  // Count of unreviewed alerts
  previousAlertIds: number[] = [];  // Store IDs of already seen alerts

  constructor(private alertService: AlertService) {}

  ngOnInit(): void {
    this.loadAlerts();

    // Check for new alerts every 5 seconds
    interval(5000).subscribe(() => {
      this.checkForNewAlerts();
    });
  }

  // Load unreviewed alerts initially
  loadAlerts(): void {
    this.alertService.getAlerts().subscribe(data => {
      this.alerts = data.filter(alert => !alert.isReviewed);
      this.unreviewedAlertCount = this.alerts.length;
      this.previousAlertIds = this.alerts.map(alert => alert.id);  // Store initial alert IDs
    });
  }

  // Polling function to check for new unreviewed alerts
  checkForNewAlerts(): void {
    this.alertService.getAlerts().subscribe(data => {
      const unreviewedAlerts = data.filter(alert => !alert.isReviewed);
      
      
      // Find new alerts (those not already in previousAlertIds)
      const newAlerts = unreviewedAlerts;

      if (newAlerts.length > 0) {
        this.showNotification(newAlerts);  // Trigger notification for new alerts
        this.previousAlertIds = [...this.previousAlertIds, ...newAlerts.map(alert => alert.id)];  // Update seen alerts
      }

      this.alerts = unreviewedAlerts;  // Update current alerts
      this.unreviewedAlertCount = this.alerts.length;  // Update alert count
    });
  }

  // Mark an alert as reviewed
  markAsReviewed(alertId: number): void {
    this.alertService.markAsReviewed(alertId).subscribe(() => {
      this.alerts = this.alerts.filter(alert => alert.id !== alertId);  // Remove the reviewed alert from the list
      this.unreviewedAlertCount = this.alerts.length;
      this.previousAlertIds = this.previousAlertIds.filter(id => id !== alertId);  // Remove from notified alerts
    });
  }

 
  notificationMessage: string | null = null;  // Stores the message to display

  // Display notifications for new alerts
  showNotification(newAlerts: any[]): void {
    if (newAlerts.length > 0) {
      
      // Combine all alerts into a single notification message
      const combinedMessage = newAlerts.map(alert => {
        return `New alert: ${alert.metricName} is out of range for Patient ID ${alert.patientId}`;
      }).join(' | ');
  
      // Set the combined notification message
      this.notificationMessage = combinedMessage;
  
      // Clear the notification after 2 seconds
      setTimeout(() => {
        this.notificationMessage = null;
      }, 3000);  // Show the notification for 2 seconds
    }
  }
  
  // Function to show toast-like notifications
  displayToast(message: string): void {
    const toast = document.createElement('div');
    toast.className = 'toast-notification';
    toast.innerText = message;
    document.body.appendChild(toast);

    setTimeout(() => {
      toast.remove();
    }, 5000); // Show the notification for 5 seconds
  }
}
