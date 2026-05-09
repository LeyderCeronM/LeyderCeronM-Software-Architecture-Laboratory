package com.fernando_mulato_leider_ceron;

import com.fernando_mulato_leider_ceron.builder.AppointmentBuilder;
import com.fernando_mulato_leider_ceron.builder.AppointmentDirector;
import com.fernando_mulato_leider_ceron.builder.ManualAppointmentBuilder;
import com.fernando_mulato_leider_ceron.builder.RescheduledAppointmentBuilder;
import com.fernando_mulato_leider_ceron.builder.SelfServiceAppointmentBuilder;
import com.fernando_mulato_leider_ceron.entities.Appointment;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		AppointmentDirector appointmentDirector = new AppointmentDirector();
		// Construir una cita manualmente
		System.out.println("---------------------------------------");
		AppointmentBuilder manual_AppointmentBuilder = new ManualAppointmentBuilder();
		appointmentDirector.setAppointmentBuilder(manual_AppointmentBuilder);
		appointmentDirector.buildAppointment();

		Appointment appointment = appointmentDirector.getAppointment();
		System.out.println("Cita Manual :" + appointment);

		// Construir una cita por autoservicio
		System.out.println("---------------------------------------");
		AppointmentBuilder selfService_AppointmentBuilder = new SelfServiceAppointmentBuilder();
		appointmentDirector.setAppointmentBuilder(selfService_AppointmentBuilder);
		appointmentDirector.buildAppointment();

		appointment = appointmentDirector.getAppointment();
		System.out.println("Cita por Autoservicio  :" + appointment);
		
		// Construir una cita reagendada
		System.out.println("---------------------------------------");
		AppointmentBuilder reschuled_AppointmentBuilder = new RescheduledAppointmentBuilder();
		appointmentDirector.setAppointmentBuilder(reschuled_AppointmentBuilder);
		appointmentDirector.buildAppointment();

		appointment = appointmentDirector.getAppointment();
		System.out.println("Cita Reagendada :" + appointment);
	}
}
