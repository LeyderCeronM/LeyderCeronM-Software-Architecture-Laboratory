package com.fernandomulato.pipeline.stages;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import com.fernandomulato.entities.Appointment;
import com.fernandomulato.pipeline.IPipelineStage;

public class CedulaFormatterStage implements IPipelineStage {

  @Override
  public String process(List<Appointment> appointments, String input) {

    @SuppressWarnings("deprecation")
    NumberFormat formatter = NumberFormat.getInstance(new Locale("es", "CO"));

    for (Appointment appointment : appointments) {

      long cedula = Long.parseLong(
          String.valueOf(appointment.getCitizenshipCardPatient())
      );

      String formatted = formatter.format(cedula);

      appointment.setCitizenshipCardPatient(formatted);
    }

    return input;
  }
}