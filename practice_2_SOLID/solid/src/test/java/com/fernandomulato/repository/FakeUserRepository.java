package com.fernandomulato.repository;

import java.util.HashMap;
import java.util.Map;

import com.fernandomulato.model.ClsUser;

public class FakeUserRepository implements IUserRepository {

    private Map<Long, ClsUser> database = new HashMap<>();
    private long idCounter = 1;

    @Override
    public ClsUser opSave(ClsUser prmUser) {
        for (ClsUser user : database.values()) {
            if (user.getAttUsername().equals(prmUser.getAttUsername())) {
                throw new IllegalArgumentException("User already exists");
            }
        }

        prmUser.setAttId(idCounter++);
        database.put(prmUser.getAttId(), prmUser);
        return prmUser;
    }

    @Override
    public boolean opDelete(long prmId) {
        return database.remove(prmId) != null;
    }

    @Override
    public boolean opUpdate(ClsUser prmUser) {
        database.put(prmUser.getAttId(), prmUser);
        return true;
    }

    @Override
    public ClsUser opGet(long prmId) {
        return database.get(prmId);
    }
}

