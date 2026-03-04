package com.fernandomulato.Infrastructure.repository;

import java.util.List;
import java.util.Optional;

import com.fernandomulato.Domain.entities.ClsAppointment;

/**
 * Abstracción (DIP): la capa de servicio depende de esta interfaz, no de una clase concreta.
 */
public interface IAppointmentRepository {
    List<ClsAppointment> findAll();
    Optional<ClsAppointment> findById(long id);
    void add(ClsAppointment appointment);
    void update(long id, ClsAppointment updated);
    void delete(long id);
}

