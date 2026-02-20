package com.fernandomulato.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClsUser {
  private long attId;
  private String attUsername;
  private String attEmail;
  private String attPassword;
  private String attRole;
  private String attProfession = "NN";

  public ClsUser(String prmUsername, String prmEmail, String prmPassword, String prmRole) {
    this.attUsername = prmUsername;
    this.attEmail = prmEmail;
    this.attPassword = prmPassword;
    this.attRole = prmRole;
  }
}


