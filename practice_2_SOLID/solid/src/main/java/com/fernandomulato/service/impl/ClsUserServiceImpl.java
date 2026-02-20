package com.fernandomulato.service.impl;

import com.fernandomulato.model.ClsUser;
import com.fernandomulato.repository.IUserRepository;
import com.fernandomulato.service.IUserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClsUserServiceImpl implements IUserService {

  private final IUserRepository objUserRepository;

  @Override
  public ClsUser opCreateUser(ClsUser prmUser) {

    ClsUser objNewUser = new ClsUser();
    if (prmUser.getAttUsername() == null || prmUser.getAttUsername().isBlank()) {
      throw new IllegalArgumentException("Username is empty");
    }

    objNewUser.setAttUsername(prmUser.getAttUsername());
    objNewUser.setAttEmail(prmUser.getAttEmail());
    objNewUser.setAttPassword(prmUser.getAttPassword());
    objNewUser.setAttRole(prmUser.getAttRole());
    objNewUser.setAttProfession(prmUser.getAttProfession());

    return objUserRepository.opSave(objNewUser);
  }

  @Override
  public boolean opUpdateUser(ClsUser prmUser, long prmId) {
    ClsUser varUser = objUserRepository.opGet(prmId);

    if (varUser == null) {
      return false;
    }

    prmUser.setAttId(varUser.getAttId());

    objUserRepository.opUpdate(prmUser);

    return true;
  }

  @Override
  public boolean opDeleteUser(long prmId) {
    ClsUser user = objUserRepository.opGet(prmId);

    if (user == null) {
      return false;
    }

    objUserRepository.opDelete(user.getAttId());
    return true;
  }

  @Override
  public ClsUser opGetUserById(long prmId) {
    ClsUser user = objUserRepository.opGet(prmId);

    if (user == null) {
      return null;
    }

    return user;
  }

}
