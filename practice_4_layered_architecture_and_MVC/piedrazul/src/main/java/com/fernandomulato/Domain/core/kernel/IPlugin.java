package com.fernandomulato.Domain.core.kernel;

/**
 * Microkernel plugin contract.
 * Plugins are loaded by ServiceLoader without changing the core.
 */
public interface IPlugin {
    String id();

    void start(ClsPluginContext context);
}
