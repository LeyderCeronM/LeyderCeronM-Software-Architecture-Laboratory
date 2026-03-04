package com.fernandomulato.Domain.entities;

import java.sql.Date;

import com.fernandomulato.Domain.enums.AttentionType;

import lombok.Data;

@Data
public class ClsAppointment {
  private long attId;
  private long attCitizenshipCardPatient;
  private String attPhoneNumberPatient;
  private long attMedicalStaffId;
  private Date attDateAndTime;
  private AttentionType attAttentionType;

  public ClsAppointment(
      long prmCitizenshipCardPatient,
      String prmPhoneNumberPatient,
      long prmMedicalStaffId,
      Date prmDateAndTime,
      AttentionType prmAttentionType) {
    this.attCitizenshipCardPatient = prmCitizenshipCardPatient;
    this.attPhoneNumberPatient = prmPhoneNumberPatient;
    this.attMedicalStaffId = prmMedicalStaffId;
    this.attDateAndTime = prmDateAndTime;
    this.attAttentionType = prmAttentionType;
  }
}
