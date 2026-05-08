package com.fernando_mulato_leider_ceron.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

@Data
public class Appointment {
  
  private Long id;
  private String patientDocument;
  private String patientName;
  private String patientPhone;
  private Long professionalId;
  private String professionalName;
  private LocalDate date;
  private LocalTime time;
  private Integer durationMinutes = 30;
  private String reason;
  private AppointmentStatus status = AppointmentStatus.AGENDADA;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  protected void onCreate() {
    createdAt = LocalDateTime.now();
    updatedAt = LocalDateTime.now();
  }
  protected void onUpdate() {
    updatedAt = LocalDateTime.now();
  }
}