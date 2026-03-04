package com.fernandomulato.Domain.core.spi;

import java.io.File;
import java.util.List;

import com.fernandomulato.Domain.entities.ClsAppointment;

/**
 * Microkernel SPI for generating a report without changing the core.
 */
public interface IReportProvider {
    String name();
    File generateReport(List<ClsAppointment> books) throws Exception;
}
