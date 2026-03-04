package com.fernandomulato.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import com.fernandomulato.Application.services.ClsAppointmentService;
import com.fernandomulato.Domain.core.events.*;
import com.fernandomulato.Domain.core.spi.IPersistenceProvider;
import com.fernandomulato.Domain.entities.ClsAppointment;
import com.fernandomulato.Infrastructure.repository.IAppointmentRepository;

class ClsAppointmentServiceTest {

  @Test
  void shouldCreateAppointmentAndPublishEvent() {
    // Arrange
    IAppointmentRepository repository = mock(IAppointmentRepository.class);
    ClsLibraryEventBus eventBus = mock(ClsLibraryEventBus.class);
    IPersistenceProvider persistence = mock(IPersistenceProvider.class);

    when(repository.findAll()).thenReturn(List.of());

    ClsAppointmentService service = new ClsAppointmentService(repository, eventBus, Optional.of(persistence));

    ClsAppointment appointment = mock(ClsAppointment.class);

    // Act
    service.create(appointment);

    // Assert
    verify(repository).add(appointment);
    verify(persistence).save(any());

    ArgumentCaptor<ClsLibraryEvent> eventCaptor = ArgumentCaptor.forClass(ClsLibraryEvent.class);

    verify(eventBus, atLeastOnce()).publish(eventCaptor.capture());

    boolean eventFound = eventCaptor.getAllValues().stream()
        .anyMatch(e -> e.getType() == LibraryEventType.APPOINTMENT_CHANGED);

    assertTrue(eventFound);
  }

  @Test
  void shouldPublishErrorMessageWhenPersistenceFails() {
    // Arrange
    IAppointmentRepository repository = mock(IAppointmentRepository.class);
    ClsLibraryEventBus eventBus = mock(ClsLibraryEventBus.class);
    IPersistenceProvider persistence = mock(IPersistenceProvider.class);

    when(repository.findAll()).thenReturn(List.of());
    doThrow(new RuntimeException("Disk error"))
        .when(persistence).save(any());

    ClsAppointmentService service = new ClsAppointmentService(repository, eventBus, Optional.of(persistence));

    ClsAppointment appointment = mock(ClsAppointment.class);

    // Act
    service.create(appointment);

    // Assert
    ArgumentCaptor<ClsLibraryEvent> captor = ArgumentCaptor.forClass(ClsLibraryEvent.class);

    verify(eventBus, atLeastOnce()).publish(captor.capture());

    boolean errorEventFound = captor.getAllValues().stream()
        .anyMatch(e -> e.getType() == LibraryEventType.STATUS_MESSAGE &&
            e.getMessage().contains("Error saving"));

    assertTrue(errorEventFound);
  }

  @Test
  void shouldLoadAppointmentsFromPluginOnStartup() throws Exception {
    // Arrange
    IAppointmentRepository repository = mock(IAppointmentRepository.class);
    ClsLibraryEventBus eventBus = mock(ClsLibraryEventBus.class);
    IPersistenceProvider persistence = mock(IPersistenceProvider.class);

    ClsAppointment appointment = mock(ClsAppointment.class);

    when(persistence.load()).thenReturn(List.of(appointment));
    when(persistence.name()).thenReturn("TestPlugin");

    // Act
    new ClsAppointmentService(repository, eventBus, Optional.of(persistence));

    // Assert
    verify(repository).add(appointment);
    verify(eventBus).publish(any(ClsLibraryEvent.class));
  }
}