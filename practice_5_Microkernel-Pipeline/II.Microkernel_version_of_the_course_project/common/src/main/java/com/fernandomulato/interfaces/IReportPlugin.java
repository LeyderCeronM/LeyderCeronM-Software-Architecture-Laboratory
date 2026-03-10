package com.fernandomulato.interfaces;

import java.util.List;

import com.fernandomulato.entities.Appointment;

public interface IReportPlugin {
  String generateReport(List<Appointment> data);
}
