package com.fernandomulato.Domain.core.kernel;

import java.util.Optional;

import com.fernandomulato.Domain.core.spi.IPersistenceProvider;
import com.fernandomulato.Domain.core.spi.IReportProvider;

/**
 * Service registry provided by the kernel to plugins and app.
 * This is the "global resource access" mentioned in microkernel slides.
 */
public final class ClsKernelServices {
    private IPersistenceProvider persistence;
    private IReportProvider report;

    public void registerPersistence(IPersistenceProvider provider) {
        this.persistence = provider;
    }

    public void registerReportProvider(IReportProvider provider) {
        this.report = provider;
    }

    public Optional<IPersistenceProvider> getPersistence() {
        return Optional.ofNullable(persistence);
    }

    public Optional<IReportProvider> getReportProvider() {
        return Optional.ofNullable(report);
    }
}
