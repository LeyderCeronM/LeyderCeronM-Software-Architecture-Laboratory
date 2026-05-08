package com.fernando_mulato_leider_ceron.builder;

import com.fernando_mulato_leider_ceron.entities.Appointment;

public abstract class AppointmentBuilder {
  protected Appointment appointment;

	public Appointment getAppointment() {
		return appointment;
	}

	public void createNewAppointment() {
		appointment = new Appointment();
	}

	public abstract void buildManualAppointment();

	public abstract void buildSelfServiceAppointment();

	public abstract void buildRescheduledAppointment();
}
