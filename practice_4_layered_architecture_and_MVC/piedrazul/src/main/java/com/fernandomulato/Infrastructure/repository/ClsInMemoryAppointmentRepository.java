package com.fernandomulato.Infrastructure.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

import com.fernandomulato.Domain.entities.ClsAppointment;
import com.fernandomulato.Domain.enums.AttentionType;

/**
 * Implementación simple en memoria.
 * (SRP) Solo gestiona almacenamiento de citas.
 */
public class ClsInMemoryAppointmentRepository implements IAppointmentRepository {

    // Usamos Long como key (NO String)
    private final Map<Long, ClsAppointment> data = new ConcurrentHashMap<>();

    public ClsInMemoryAppointmentRepository() {

        // Datos semilla (ahora generando ID automático)
        add(new ClsAppointment(
                1002457658,
                "3204587849",
                111,
                Date.valueOf("2026-03-04"),
                AttentionType.General));

        add(new ClsAppointment(
                1084841865,
                "3248791548",
                212,
                Date.valueOf("2026-03-04"),
                AttentionType.Specialized));
    }

    // ============================
    // Generador de ID único
    // ============================

    private long generateUniqueId() {
        long id;
        do {
            id = ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);
        } while (data.containsKey(id));
        return id;
    }

    // ============================
    // CRUD
    // ============================

    @Override
    public List<ClsAppointment> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Optional<ClsAppointment> findById(long id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public void add(ClsAppointment appointment) {

        Objects.requireNonNull(appointment);

        //  Si el ID viene en 0 → lo generamos
        if (appointment.getAttId() == 0) {
            long newId = generateUniqueId();
            appointment.setAttId(newId);
        }

        if (data.containsKey(appointment.getAttId())) {
            throw new IllegalArgumentException("There is already an appointment with that ID.");
        }

        data.put(appointment.getAttId(), appointment);
    }

    @Override
    public void update(long id, ClsAppointment updated) {

        Objects.requireNonNull(updated);

        if (!data.containsKey(id)) {
            throw new NoSuchElementException("There is no appointment with ID: " + id);
        }

        long newId = updated.getAttId();

        // Validar colisión si cambia el ID
        if (id != newId && data.containsKey(newId)) {
            throw new IllegalArgumentException("The new ID already exists.");
        }

        data.remove(id);
        data.put(newId, updated);
    }

    @Override
    public void delete(long id) {
        data.remove(id);
    }
}