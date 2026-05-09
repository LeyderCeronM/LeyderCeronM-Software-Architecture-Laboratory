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
		Appointment manualAppointment = appointmentDirector.buildManualAppointment();
        System.out.println("\n---------------------------------------");
        System.out.println("           CITA MANUAL");
        System.out.println("---------------------------------------");
        System.out.println(manualAppointment);

		// Construir una cita por autoservicio
		Appointment selfServiceAppointment = appointmentDirector.buildSelfServiceAppointment();
        System.out.println("\n---------------------------------------");
        System.out.println("      CITA POR AUTOSERVICIO");
        System.out.println("---------------------------------------");
        System.out.println(selfServiceAppointment);

		// Construir una cita reagendada
		System.out.println("\n---------------------------------------");
		System.out.println("         CITA REAGENDADA");
		System.out.println("---------------------------------------");
		Appointment rescheduledAppointment = appointmentDirector.buildRescheduledAppointment();
		System.out.println(rescheduledAppointment);
	
	}
}
