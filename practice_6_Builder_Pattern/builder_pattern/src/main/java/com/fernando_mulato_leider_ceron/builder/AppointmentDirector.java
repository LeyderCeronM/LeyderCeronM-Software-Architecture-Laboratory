package com.fernando_mulato_leider_ceron.builder;

import com.fernando_mulato_leider_ceron.entities.Appointment;

public class AppointmentDirector {
  private AppointmentBuilder appointmentBuilder;

	public void setAppointmentBuilder(AppointmentBuilder appointmentBuilder) {
		this.appointmentBuilder = appointmentBuilder;
	}

	public Appointment getAppointment() {
		return appointmentBuilder.getAppointment();
	}

	public void buildAppointment() {
		appointmentBuilder.createNewAppointment();
		appointmentBuilder.buildPatientData();
		appointmentBuilder.buildProfessionalData();
		appointmentBuilder.buildData();
		appointmentBuilder.buildAppointmentType();
	}
}

