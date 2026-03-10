package com.fernandomulato.pipeline.stages;

import java.util.List;

import com.fernandomulato.entities.Appointment;
import com.fernandomulato.pipeline.IPipelineStage;

public class ValidationStage implements IPipelineStage {

    @Override
    public String process(List<Appointment> appointments, String input) {

        if (appointments == null || appointments.isEmpty()) {
            throw new RuntimeException("La lista de citas está vacía");
        }

        return input;
    }
}