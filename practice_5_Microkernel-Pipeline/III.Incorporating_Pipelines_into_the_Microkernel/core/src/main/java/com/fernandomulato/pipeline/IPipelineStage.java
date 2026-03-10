package com.fernandomulato.pipeline;

import java.util.List;
import com.fernandomulato.entities.Appointment;

public interface IPipelineStage {

  String process(List<Appointment> appointments, String input);

}