package com.fernandomulato.Domain.core.spi;

import java.util.List;

import com.fernandomulato.Domain.entities.ClsAppointment;

/**
 * Microkernel SPI (Service Provider Interface) for persistence.
 * A plugin can provide a concrete implementation (CSV, DB, etc).
 */
public interface IPersistenceProvider {
    String name();
    List<ClsAppointment> load();
    void save(List<ClsAppointment> books);
}