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

    objNewUser.setAttUsername(prmUser.getAttUsername());
    objNewUser.setAttEmail(prmUser.getAttEmail());
    objNewUser.setAttPassword(prmUser.getAttPassword());
    objNewUser.setAttRole(prmUser.getAttRole());
    objNewUser.setAttProfession(prmUser.getAttProfession());

    return objUserRepository.opSave(objNewUser);
  }

  @Override
  public boolean opUpdateUser(ClsUser prmUserDTO, long prmId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'opUpdateUser'");
  }

  @Override
  public boolean opDeleteUser(long prmId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'opDeleteUser'");
  }

  @Override
  public ClsUser opGetUserById(long prmId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'opGetUserById'");
  }

}
