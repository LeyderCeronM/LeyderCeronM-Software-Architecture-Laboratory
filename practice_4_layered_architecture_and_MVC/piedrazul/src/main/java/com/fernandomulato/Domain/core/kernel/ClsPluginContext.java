package com.fernandomulato.Domain.core.kernel;

import com.fernandomulato.Domain.core.events.ClsLibraryEventBus;

public final class ClsPluginContext {
    private final ClsLibraryEventBus eventBus;
    private final ClsKernelServices services;

    ClsPluginContext(ClsLibraryEventBus eventBus, ClsKernelServices services) {
        this.eventBus = eventBus;
        this.services = services;
    }

    public ClsLibraryEventBus eventBus() { return eventBus; }
    public ClsKernelServices services() { return services; }
}
