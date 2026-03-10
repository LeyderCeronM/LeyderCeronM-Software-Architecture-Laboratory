package com.fernandomulato.entities;

import java.sql.Date;

/**
 * Appointment
 * @author Fernando Mulato
 */
public class Appointment {
  private long id;
  private String citizenshipCardPatient;
  private String formattedDate;
  private String patientName;
  private String phoneNumberPatient;
  private long medicalStaffId;
  private String doctorName;
  private Date dateAndTime; 

  public Appointment(
    long id, 
    String citizenshipCardPatient, 
    String patientName,
    String phoneNumberPatient, 
    long medicalStaffId,
    String doctorName, 
    Date dateAndTime){
    this.id = id;
    this.citizenshipCardPatient = citizenshipCardPatient;
    this.patientName = patientName;
    this.phoneNumberPatient = phoneNumberPatient;
    this.medicalStaffId = medicalStaffId;
    this.doctorName = doctorName;
    this.dateAndTime = dateAndTime;
  }

  public long getId() {
    return this.id;
  }

  public String getCitizenshipCardPatient() {
    return this.citizenshipCardPatient;
  } 

  public String getPatientName() {
    return this.patientName;
  }

  public String getPhoneNumberPatient() {
    return this.phoneNumberPatient;
  } 

  public long getMedicalStaffId() {
    return this.medicalStaffId;
  } 

  public String getDoctorName() {
    return this.doctorName;
  }

  public Date getDateAndTime() {
    return this.dateAndTime;
  } 

  public void setPatientName(String patientName) {
    this.patientName = patientName;
  }

  public void setDoctorName(String doctorName) {
    this.doctorName = doctorName;
  }

  public void setCitizenshipCardPatient(String citizenshipCardPatient) {
    this.citizenshipCardPatient = citizenshipCardPatient;
  }

  public void setDateAndTime(Date dateAndTime) {
    this.dateAndTime = dateAndTime;
  }

  public String getFormattedDate() {
  return formattedDate;
}

public void setFormattedDate(String formattedDate) {
  this.formattedDate = formattedDate;
}
}
