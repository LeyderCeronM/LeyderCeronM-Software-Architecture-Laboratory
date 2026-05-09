package com.fernando_mulato_leider_ceron.builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class RescheduledAppointmentBuilder extends AppointmentBuilder {

  @Override
    public void buildPatientData() {
        appointment.setId(34l);
        appointment.setPatientDocument("3003");
        appointment.setPatientName("Juan Torres");
        appointment.setPatientPhone("3208889999");
    }

    @Override
    public void buildProfessionalData() {
        appointment.setProfessionalId(3L);
        appointment.setProfessionalName("Dr. Ricardo");
    }

    @Override
    public void buildData() {
        appointment.setDate(LocalDate.now().plusDays(3));
        appointment.setTime(LocalTime.of(15, 0));
    }

    @Override
    public void buildAppointmentType() {
        appointment.setReason("Cita reagendada");
        appointment.setCreatedAt(LocalDateTime.now());
        appointment.setUpdatedAt(LocalDateTime.now());
    }

}
