import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlertComponent } from './alert/alert.component';
import { ThresholdsComponent } from './thresholds/thresholds.component';
import { AlertService } from './services/alert.service';
import { ThresholdsService } from './services/thresholds.service';
import { MockDataComponent } from './mock-data/mock-data.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    AlertComponent,
    ThresholdsComponent,
    MockDataComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [AlertService, ThresholdsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
