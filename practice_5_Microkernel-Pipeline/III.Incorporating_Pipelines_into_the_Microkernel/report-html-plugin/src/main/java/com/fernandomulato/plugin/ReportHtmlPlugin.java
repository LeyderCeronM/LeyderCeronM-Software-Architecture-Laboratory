package com.fernandomulato.plugin;

import java.util.List;

import com.fernandomulato.entities.Appointment;
import com.fernandomulato.interfaces.IReportPlugin;

/**
 * Plugin for html reports
 * 
 * @author Fernando Mulato
 */
public class ReportHtmlPlugin implements IReportPlugin {

  @Override
  public String generateReport(List<Appointment> data) {

    StringBuilder html = new StringBuilder();

    html.append("<!DOCTYPE html>\n");
    html.append("<html lang=\"es\">\n");
    html.append("  <head>\n");
    html.append("    <title>Reporte de Citas</title>\n");
    html.append("  </head>\n");
    html.append("  <body>\n");

    html.append("    <h1>Reporte de Citas</h1>\n");

    html.append("    <table border=\"1\">\n");

    html.append("      <tr>\n");
    html.append("        <th>ID</th>\n");
    html.append("        <th>Citizenship Card</th>\n");
    html.append("        <th>Patient Name</th>\n");
    html.append("        <th>Phone</th>\n");
    html.append("        <th>Medical Staff ID</th>\n");
    html.append("        <th>Doctor Name</th>\n");
    html.append("        <th>Date</th>\n");
    html.append("      </tr>\n");

    for (Appointment appointment : data) {

      html.append("      <tr>\n");

      html.append("        <td>")
          .append(appointment.getId())
          .append("</td>\n");

      html.append("        <td>")
          .append(appointment.getCitizenshipCardPatient())
          .append("</td>\n");
      
      html.append("        <td>")
          .append(appointment.getPatientName())
          .append("</td>\n");

      html.append("        <td>")
          .append(appointment.getPhoneNumberPatient())
          .append("</td>\n");

      html.append("        <td>")
          .append(appointment.getMedicalStaffId())
          .append("</td>\n");

      html.append("        <td>")
          .append(appointment.getDoctorName())
          .append("</td>\n");
      
      html.append("        <td>")
          .append(appointment.getFormattedDate())
          .append("</td>\n");

      html.append("      </tr>\n");
    }

    html.append("    </table>\n");
    html.append("  </body>\n");
    html.append("</html>\n");

    return html.toString();
  }
}