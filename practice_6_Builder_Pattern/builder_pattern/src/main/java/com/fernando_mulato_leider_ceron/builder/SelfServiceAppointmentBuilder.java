package com.fernando_mulato_leider_ceron.builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SelfServiceAppointmentBuilder extends AppointmentBuilder {

   @Override
    public void buildPatientData() {
        appointment.setId(2l);
        appointment.setPatientDocument("2002");
        appointment.setPatientName("Maria Lopez");
        appointment.setPatientPhone("3015556677");
    }

    @Override
    public void buildProfessionalData() {
        appointment.setProfessionalId(2L);
        appointment.setProfessionalName("Dra. Camila");
    }

    @Override
    public void buildData() {
        appointment.setDate(LocalDate.now().plusDays(1));
        appointment.setTime(LocalTime.of(11, 30));
    }

    @Override
    public void buildAppointmentType() {
        appointment.setReason("Cita generada por autoservicio");
        appointment.setCreatedAt(LocalDateTime.now());
        appointment.setUpdatedAt(LocalDateTime.now());
    }

}
