package com.fernando_mulato_leider_ceron.builder;

import com.fernando_mulato_leider_ceron.entities.Appointment;

public class AppointmentDirector {
	//cumple  el punto 4 de la guia director, el cual se encarga de construir los objetos utilizando los builders concretos
	public Appointment buildManualAppointment() {
		
        AppointmentBuilder builder = new ManualAppointmentBuilder();

        builder.createNewAppointment();
        builder.buildPatientData();
        builder.buildProfessionalData();
        builder.buildData();
        builder.buildAppointmentType();
        return builder.getAppointment();
    }

    public Appointment buildSelfServiceAppointment() {

        AppointmentBuilder builder = new SelfServiceAppointmentBuilder();

        builder.createNewAppointment();
        builder.buildPatientData();
        builder.buildProfessionalData();
        builder.buildData();
        builder.buildAppointmentType();
        return builder.getAppointment();
    }

    public Appointment buildRescheduledAppointment() {

        AppointmentBuilder builder = new RescheduledAppointmentBuilder();

        builder.createNewAppointment();
        builder.buildPatientData();
        builder.buildProfessionalData();
        builder.buildData();
        builder.buildAppointmentType();
        return builder.getAppointment();
    }
}

