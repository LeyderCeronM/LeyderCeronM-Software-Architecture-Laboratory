package com.fernandomulato.Application.services;

import java.util.List;
import java.util.Optional;

import com.fernandomulato.Domain.core.events.ClsLibraryEvent;
import com.fernandomulato.Domain.core.events.ClsLibraryEventBus;
import com.fernandomulato.Domain.core.events.LibraryEventType;
import com.fernandomulato.Domain.core.spi.IPersistenceProvider;
import com.fernandomulato.Domain.entities.ClsAppointment;
import com.fernandomulato.Infrastructure.repository.IAppointmentRepository;

/**
 * (SRP) Orquesta reglas de negocio del CRUD.
 * Publica eventos -> Observer (Views).
 * Opcionalmente usa un PersistenceProvider (plugin, microkernel).
 */
public class ClsAppointmentService {
    private final IAppointmentRepository repository;
    private final ClsLibraryEventBus eventBus;
    private final Optional<IPersistenceProvider> persistence;

    public ClsAppointmentService(IAppointmentRepository repository, ClsLibraryEventBus eventBus, Optional<IPersistenceProvider> persistence) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.persistence = persistence;

        // Cargar datos desde plugin si está disponible
        persistence.ifPresent(p -> {
            try {
                List<ClsAppointment> loaded = p.load();
                if (loaded != null && !loaded.isEmpty()) {
                    loaded.forEach(repository::add);
                    eventBus.publish(new ClsLibraryEvent(LibraryEventType.STATUS_MESSAGE,
                        "Data uploaded from plugin: " + p.name()));
                }
            } catch (Exception ex) {
                eventBus.publish(new ClsLibraryEvent(LibraryEventType.STATUS_MESSAGE,
                    "Unable to load from plugin: " + ex.getMessage()));
            }
        });
    }

    public List<ClsAppointment> list() {
        return repository.findAll();
    }

    public void create(ClsAppointment appointment) {
        repository.add(appointment);
        persistAndNotify("Appointment created.");
    }

    public void update(long originalId, ClsAppointment updated) {
        repository.update(originalId, updated);
        persistAndNotify("Appointment updated.");
    }

    public void delete(long id) {
        repository.delete(id);
        persistAndNotify("Appointment deleted.");
    }

    public Optional<ClsAppointment> findById(long id) {
        return repository.findById(id);
    }

    private void persistAndNotify(String message) {
        persistence.ifPresent(p -> {
            try {
                p.save(repository.findAll());
            } catch (Exception ex) {
                eventBus.publish(new ClsLibraryEvent(LibraryEventType.STATUS_MESSAGE,
                    "Error saving (" + p.name() + "): " + ex.getMessage()));
            }
        });
        eventBus.publish(new ClsLibraryEvent(LibraryEventType.APPOINTMENT_CHANGED, message));
    }
}

