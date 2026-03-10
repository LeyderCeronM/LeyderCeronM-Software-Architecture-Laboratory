package com.fernandomulato.business;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fernandomulato.entities.Appointment;

public class AppointmentService {

  public List<Appointment> getAll() {

    List<Appointment> appointments = new ArrayList<>();

    /*
     * En un escenario normal, los productos vendrían de la capa de acceso a datos.
     * Para este ejemplo, se crearán objetos de prueba directamente aquí.
     */
    Appointment appointmentOne = new Appointment(1, "1003654879","fernando rodriguez", "+57 3204564568", 100, "marcos gonzales", Date.valueOf("2026-03-21"));
    Appointment appointmentTwo = new Appointment(2, "1020449844", "luis martinez", "+57 3204564568", 100, "marcos gonzales", Date.valueOf("2026-03-20"));
    Appointment appointmentThree = new Appointment(3, "1002654469", "Martha Smith", "+57 3204564568", 100, "marcos gonzales", Date.valueOf("2026-03-19"));

    appointments.add(appointmentOne);
    appointments.add(appointmentTwo);
    appointments.add(appointmentThree);

    return appointments;
  }

}
