package com.fernandomulato.repository;

import com.fernandomulato.model.ClsUser;

public interface IUserRepository {

  ClsUser opSave(ClsUser user);
  boolean opDelete(long id);
  boolean opUpdate(ClsUser user);
  ClsUser opGet(long id);
}
