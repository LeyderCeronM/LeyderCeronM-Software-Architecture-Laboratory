package com.fernando_mulato_leider_ceron.builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ManualAppointmentBuilder extends AppointmentBuilder {
  // implementamos builders concretos, punto 3 de la guia
  @Override
  public void buildPatientData() {
    appointment.setId(13l);
    appointment.setPatientDocument("9001");
    appointment.setPatientName("leyder ceron");
    appointment.setPatientPhone("1234567891");
  }

  @Override
  public void buildProfessionalData() {
    appointment.setProfessionalId(1l);
    appointment.setProfessionalName("Dr. jeison");
  }

  @Override
  public void buildData() {
    appointment.setDate(LocalDate.now());
    appointment.setTime(LocalTime.of(9,0));
  }

  @Override
  public void buildAppointmentType() {
    appointment.setReason("Cita registrada manualmente");
    appointment.setCreatedAt(LocalDateTime.now());
    appointment.setUpdatedAt(LocalDateTime.now());
  }

}
