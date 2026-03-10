package com.fernandomulato.pipeline.stages;

import java.util.List;

import com.fernandomulato.entities.Appointment;
import com.fernandomulato.interfaces.IReportPlugin;
import com.fernandomulato.pipeline.IPipelineStage;
import com.fernandomulato.plugin.manager.ReportPluginManager;

public class PluginStage implements IPipelineStage {

    private String reportType;

    public PluginStage(String reportType) {
        this.reportType = reportType;
    }

    @Override
    public String process(List<Appointment> appointments, String input) {

        IReportPlugin plugin =
                ReportPluginManager.getInstance()
                        .getReportPlugin(reportType);

        if (plugin == null) {
            throw new RuntimeException("Plugin no encontrado");
        }

        return plugin.generateReport(appointments);
    }
}