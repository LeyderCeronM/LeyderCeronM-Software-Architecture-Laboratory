package com.fernandomulato.pipeline.stages;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import com.fernandomulato.entities.Appointment;
import com.fernandomulato.pipeline.IPipelineStage;

public class TransformDateStage implements IPipelineStage {

  @Override
  public String process(List<Appointment> appointments, String input) {

    @SuppressWarnings("deprecation")
    SimpleDateFormat formatter =
        new SimpleDateFormat("dd-MMM-yyyy", new Locale("es", "ES"));

    for (Appointment appointment : appointments) {

      String formattedDate =
          formatter.format(appointment.getDateAndTime()).toLowerCase();

      appointment.setFormattedDate(formattedDate);
    }

    return input;
  }
}