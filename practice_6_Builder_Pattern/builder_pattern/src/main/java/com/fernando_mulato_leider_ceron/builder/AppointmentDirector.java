package com.fernando_mulato_leider_ceron.builder;

import com.fernando_mulato_leider_ceron.entities.Appointment;

public class AppointmentDirector {
  private AppointmentBuilder appointmentBuilder;

	public void setAppointmentBuilder(AppointmentBuilder ab) {
		appointmentBuilder = ab;
	}

	public Appointment getAppointment() {
		return appointmentBuilder.getAppointment();
	}

	public void buildAppointment() {
		appointmentBuilder.createNewAppointment();
		appointmentBuilder.buildManualAppointment();
		appointmentBuilder.buildSelfServiceAppointment();
		appointmentBuilder.buildRescheduledAppointment();
	}
}

