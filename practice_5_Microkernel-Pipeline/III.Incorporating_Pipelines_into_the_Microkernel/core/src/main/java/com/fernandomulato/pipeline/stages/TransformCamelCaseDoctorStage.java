package com.fernandomulato.pipeline.stages;

import java.util.List;

import com.fernandomulato.entities.Appointment;
import com.fernandomulato.pipeline.IPipelineStage;

public class TransformCamelCaseDoctorStage implements IPipelineStage {

  @Override
  public String process(List<Appointment> appointments, String input) {

    for (Appointment appointment : appointments) {

      String name = appointment.getDoctorName();

      appointment.setDoctorName(toCamelCase(name));
    }

    return input;
  }

  private String toCamelCase(String text) {

    String[] words = text.split(" ");
    StringBuilder result = new StringBuilder();

    for (String word : words) {

      result.append(Character.toUpperCase(word.charAt(0)))
            .append(word.substring(1).toLowerCase())
            .append(" ");
    }

    return result.toString().trim();
  }
}