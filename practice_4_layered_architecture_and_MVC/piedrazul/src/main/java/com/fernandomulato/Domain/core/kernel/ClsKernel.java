package com.fernandomulato.Domain.core.kernel;

import java.util.ServiceLoader;

import com.fernandomulato.Domain.core.events.ClsLibraryEvent;
import com.fernandomulato.Domain.core.events.ClsLibraryEventBus;
import com.fernandomulato.Domain.core.events.LibraryEventType;
import com.fernandomulato.Domain.core.spi.IPersistenceProvider;

public final class ClsKernel {
    private final ClsLibraryEventBus eventBus = new ClsLibraryEventBus();
    private final ClsKernelServices services = new ClsKernelServices();

    private ClsKernel() {}

    public static ClsKernel defaultKernel() {
        return new ClsKernel();
    }

    public ClsLibraryEventBus getEventBus() {
        return eventBus;
    }

    public ClsKernelServices getServices() {
        return services;
    }

    public java.util.Optional<IPersistenceProvider> getOptionalPersistence() {
        return services.getPersistence();
    }

    public void loadPlugins() {
        ServiceLoader<IPlugin> loader = ServiceLoader.load(IPlugin.class);
        ClsPluginContext ctx = new ClsPluginContext(eventBus, services);

        int count = 0;
        for (IPlugin p : loader) {
            try {
                p.start(ctx);
                count++;
            } catch (Exception ex) {
                eventBus.publish(new ClsLibraryEvent(
                    LibraryEventType.STATUS_MESSAGE,
                    "Plugin error (" + p.id() + "): " + ex.getMessage()
                ));
            }
        }
        eventBus.publish(new ClsLibraryEvent(
            LibraryEventType.STATUS_MESSAGE,
            "Kernel: " + count + " plugin(s) loaded."
        ));
    }
}

