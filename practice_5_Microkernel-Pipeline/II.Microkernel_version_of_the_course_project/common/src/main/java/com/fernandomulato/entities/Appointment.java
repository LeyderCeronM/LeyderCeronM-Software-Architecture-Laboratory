package com.fernandomulato.entities;

import java.sql.Date;

/**
 * Appointment
 * @author Fernando Mulato
 */
public class Appointment {
  private long id;
  private long citizenshipCardPatient;
  private String phoneNumberPatient;
  private long medicalStaffId;
  private Date dateAndTime; 

  public Appointment(
    long id, 
    long citizenshipCardPatient, 
    String phoneNumberPatient, 
    long medicalStaffId, 
    Date dateAndTime){
    this.id = id;
    this.citizenshipCardPatient = citizenshipCardPatient;
    this.phoneNumberPatient = phoneNumberPatient;
    this.medicalStaffId = medicalStaffId;
    this.dateAndTime = dateAndTime;
  }

  public long getId() {
    return this.id;
  }

  public long getCitizenshipCardPatient() {
    return this.citizenshipCardPatient;
  } 

  public String getPhoneNumberPatient() {
    return this.phoneNumberPatient;
  } 

  public long getMedicalStaffId() {
    return this.medicalStaffId;
  } 

  public Date getDateAndTime() {
    return this.dateAndTime;
  } 
}
