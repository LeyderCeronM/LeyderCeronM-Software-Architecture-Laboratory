package com.fernando_mulato_leider_ceron.builder;

import com.fernando_mulato_leider_ceron.entities.Appointment;

public abstract class AppointmentBuilder {
  	protected Appointment appointment;
	// punto 2 de la guia, la calse abstracta
	public Appointment getAppointment() {
		return appointment;
	}

	public void createNewAppointment() {
		appointment = new Appointment();
	}

	public abstract void buildPatientData();
	public abstract void buildProfessionalData();
	public abstract void buildData();
	public abstract void buildAppointmentType();
}
