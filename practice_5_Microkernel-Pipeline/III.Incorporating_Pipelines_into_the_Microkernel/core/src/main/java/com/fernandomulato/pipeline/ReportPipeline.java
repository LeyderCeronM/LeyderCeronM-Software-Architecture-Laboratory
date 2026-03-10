package com.fernandomulato.pipeline;

import java.util.ArrayList;
import java.util.List;

import com.fernandomulato.entities.Appointment;

public class ReportPipeline {

    private List<IPipelineStage> stages = new ArrayList<>();

    public void addStage(IPipelineStage stage) {
        stages.add(stage);
    }

    public String execute(List<Appointment> appointments) {

        String result = "";

        for (IPipelineStage stage : stages) {
            result = stage.process(appointments, result);
        }

        return result;
    }
}