package com.fernandomulato.controller;

import com.fernandomulato.model.ClsUser;
import com.fernandomulato.service.IUserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClsUserController {

  private final IUserService objUserService;

  public ClsUser createUser(ClsUser prmUser) {
    return objUserService.opCreateUser(prmUser);
  }

  public boolean updateUser(ClsUser prmUser, long prmId) {
    return objUserService.opUpdateUser(prmUser, prmId);
  }

  public boolean deleteUser(long prmId) {
    return objUserService.opDeleteUser(prmId);
  }

  public ClsUser getUserById(long prmId) {
    return objUserService.opGetUserById(prmId);
  }
}
