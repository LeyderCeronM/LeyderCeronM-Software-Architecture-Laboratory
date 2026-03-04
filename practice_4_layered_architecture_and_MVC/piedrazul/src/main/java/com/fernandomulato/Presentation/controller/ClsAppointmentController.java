package com.fernandomulato.Presentation.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.fernandomulato.Application.services.ClsAppointmentService;
import com.fernandomulato.Domain.entities.ClsAppointment;
import com.fernandomulato.Domain.enums.AttentionType;

/**
 * Controller (MVC): adapta acciones de la UI a la capa de servicio.
 * (SRP) Solo coordina entrada/salida, no reglas de negocio.
 */
public class ClsAppointmentController {
	private final ClsAppointmentService service;

	public ClsAppointmentController(ClsAppointmentService service) {
		this.service = service;
	}

	public List<ClsAppointment> list() {
		return service.list();
	}

	public void create(
			long prmCitizenshipCardPatient,
			String prmPhoneNumberPatient,
			long prmMedicalStaffId,
			Date prmDateAndTime,
			AttentionType prmAttentionType) {
		service.create(
				new ClsAppointment(
						prmCitizenshipCardPatient,
						prmPhoneNumberPatient,
						prmMedicalStaffId,
						prmDateAndTime,
						prmAttentionType));
	}

	public void update(
			long prmOriginalId,
			long prmCitizenshipCardPatient,
			String prmPhoneNumberPatient,
			long prmMedicalStaffId,
			Date prmDateAndTime,
			AttentionType prmAttentionType) {
		service.update(
				prmOriginalId,
				new ClsAppointment(
						prmCitizenshipCardPatient,
						prmPhoneNumberPatient,
						prmMedicalStaffId,
						prmDateAndTime,
						prmAttentionType));
	}

	public void delete(long id) {
		service.delete(id);
	}

	public Optional<ClsAppointment> findById(long id) {
		return service.findById(id);
	}
}
