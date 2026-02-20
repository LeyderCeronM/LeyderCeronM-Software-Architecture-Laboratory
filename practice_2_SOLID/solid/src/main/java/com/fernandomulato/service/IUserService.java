package com.fernandomulato.service;

import com.fernandomulato.model.ClsUser;

public interface IUserService {

  ClsUser opCreateUser(ClsUser prmUser);
  boolean opUpdateUser(ClsUser prmUserDTO, long prmId);
  boolean opDeleteUser(long prmId);
  ClsUser opGetUserById(long prmId);
}
