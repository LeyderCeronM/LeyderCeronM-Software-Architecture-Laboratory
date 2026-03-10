package com.fernandomulato.plugin;

import java.util.List;

import com.fernandomulato.entities.Appointment;
import com.fernandomulato.interfaces.IReportPlugin;

/**
 * Plugin for reports in JSON
 * 
 * @author Fernando Mulato
 */
public class ReportJsonPlugin implements IReportPlugin {

  @Override
  public String generateReport(List<Appointment> data) {

    StringBuilder json = new StringBuilder();

    json.append("{\n");
    json.append("  \"appointments\": [\n");

    for (int i = 0; i < data.size(); i++) {

      Appointment appointment = data.get(i);

      json.append("    {\n");

      json.append("      \"id\": ")
          .append(appointment.getId())
          .append(",\n");

      json.append("      \"citizenshipCardPatient\": ")
          .append(appointment.getCitizenshipCardPatient())
          .append(",\n");

      json.append("      \"phoneNumberPatient\": \"")
          .append(appointment.getPhoneNumberPatient())
          .append("\",\n");

      json.append("      \"medicalStaffId\": ")
          .append(appointment.getMedicalStaffId())
          .append(",\n");

      json.append("      \"dateAndTime\": \"")
          .append(appointment.getDateAndTime())
          .append("\"\n");

      json.append("    }");

      if (i < data.size() - 1) {
        json.append(",");
      }

      json.append("\n");
    }

    json.append("  ]\n");
    json.append("}");

    return json.toString();
  }
}