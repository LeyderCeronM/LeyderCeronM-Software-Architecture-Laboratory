package com.fernandomulato.presentation;

import java.util.List;
import java.util.Scanner;

import com.fernandomulato.business.AppointmentService;
import com.fernandomulato.entities.Appointment;
import com.fernandomulato.pipeline.ReportPipeline;
import com.fernandomulato.pipeline.stages.ValidationStage;
import com.fernandomulato.pipeline.stages.CedulaFormatterStage;
import com.fernandomulato.pipeline.stages.TransformDateStage;
import com.fernandomulato.pipeline.stages.PluginStage;
import com.fernandomulato.pipeline.stages.TransformCamelCaseDoctorStage;
import com.fernandomulato.pipeline.stages.TransformCamelCaseNameStage;

public class Console {

  private AppointmentService appointmentService;
  private Scanner scanner;

  public Console() {
    appointmentService = new AppointmentService();
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
      scanner.nextLine();

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

    try {

      // Crear pipeline
      ReportPipeline pipeline = new ReportPipeline();

      // Agregar stages
      pipeline.addStage(new ValidationStage());
      pipeline.addStage(new CedulaFormatterStage());
      pipeline.addStage(new TransformCamelCaseNameStage());
      pipeline.addStage(new TransformCamelCaseDoctorStage());
      pipeline.addStage(new TransformDateStage());
      pipeline.addStage(new PluginStage(reportType));

      // Ejecutar pipeline
      String report = pipeline.execute(appointments);

      System.out.println("\nReporte generado:\n");
      System.out.println(report);

    } catch (Exception e) {

      System.out.println("Error generando el reporte: " + e.getMessage());

    }
  }
}