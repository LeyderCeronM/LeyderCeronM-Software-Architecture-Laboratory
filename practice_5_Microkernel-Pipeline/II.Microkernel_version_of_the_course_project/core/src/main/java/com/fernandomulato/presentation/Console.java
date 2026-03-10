package com.fernandomulato.presentation;

import java.util.List;
import java.util.Scanner;

import com.fernandomulato.business.AppointmentService;
import com.fernandomulato.entities.Appointment;
import com.fernandomulato.interfaces.IReportPlugin;
import com.fernandomulato.plugin.manager.ReportPluginManager;

public class Console {

  private AppointmentService appointmentService;
  private ReportPluginManager reportPluginManager;
  private Scanner scanner;

  public Console() {
    appointmentService = new AppointmentService();
    reportPluginManager = ReportPluginManager.getInstance();
    scanner = new Scanner(System.in);
  }

  public void start() {

    int option;

    System.out.println("Aplicación de Reportes de Citas (Microkernel)");

    do {

      System.out.println();
      System.out.println("1. Generar reporte de citas");
      System.out.println("2. Salir");

      option = scanner.nextInt();
      scanner.nextLine(); // limpiar buffer

      switch (option) {
        case 1:
          generateReport();
          break;
      }

    } while (option != 2);

    System.out.println("Aplicación terminada");
  }

  private void generateReport() {

    List<Appointment> appointments = appointmentService.getAll();

    if (appointments.isEmpty()) {
      System.out.println("No hay citas registradas.");
      return;
    }

    System.out.println("Tipos de reporte disponibles:");
    System.out.println("1. HTML");
    System.out.println("2. JSON");
    System.out.println("3. PDF");

    int option = scanner.nextInt();
    scanner.nextLine();

    String reportType = "";

    switch (option) {
      case 1:
        reportType = "html";
        break;
      case 2:
        reportType = "json";
        break;
      case 3:
        reportType = "pdf";
        break;
      default:
        System.out.println("Tipo de reporte inválido");
        return;
    }

    IReportPlugin plugin = reportPluginManager.getReportPlugin(reportType);

    if (plugin == null) {
      System.out.println("No existe plugin para el tipo: " + reportType);
      return;
    }

    try {

      String report = plugin.generateReport(appointments);

      System.out.println("\nReporte generado:\n");
      System.out.println(report);

    } catch (Exception e) {

      System.out.println("Error generando el reporte: " + e.getMessage());

    }
  }
}