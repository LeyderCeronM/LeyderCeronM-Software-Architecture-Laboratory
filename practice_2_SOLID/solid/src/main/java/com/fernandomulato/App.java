package com.fernandomulato;

import com.fernandomulato.controller.ClsUserController;
import com.fernandomulato.repository.impl.ClsSQLiteConnection;
import com.fernandomulato.repository.impl.ClsSQLiteUserRepository;
import com.fernandomulato.service.impl.ClsUserServiceImpl;
import com.fernandomulato.view.ClsUserView;

public class App {

    public static void main(String[] args) {
        var databaseConnection = new ClsSQLiteConnection();
        var repository = new ClsSQLiteUserRepository(databaseConnection);
        var service = new ClsUserServiceImpl(repository);
        var controller = new ClsUserController(service);
        var view = new ClsUserView(controller);

        view.start();
    }
}
