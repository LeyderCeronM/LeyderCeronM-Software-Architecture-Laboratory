package com.fernandomulato.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fernandomulato.model.ClsUser;
import com.fernandomulato.service.IUserService;

public class uTestUserController {

    private IUserService userService;
    private ClsUserController controller;

    @BeforeEach
    void setUp() {
        userService = mock(IUserService.class);
        controller = new ClsUserController(userService);
    }

    // 1. Registro exitoso
    @Test
    void shouldCreateUserSuccessfully() {

        ClsUser user = new ClsUser("Fernando", "fernando@mail.com", "1234", "USER");
        ClsUser savedUser = new ClsUser(1L, "Fernando", "fernando@mail.com", "1234", "USER", "Dev");

        when(userService.opCreateUser(user)).thenReturn(savedUser);

        ClsUser result = controller.createUser(user);

        assertNotNull(result);
        assertEquals(1L, result.getAttId());
    }

    // 2. Registro inválido por campos obligatorios
    @Test
    void shouldFailWhenRequiredFieldsAreEmpty() {

        ClsUser user = new ClsUser( "", "", "1234", "USER");

        when(userService.opCreateUser(user))
                .thenThrow(new IllegalArgumentException("Required fields missing"));

        assertThrows(IllegalArgumentException.class,
                () -> controller.createUser(user));
    }

    // 3. Registro inválido por edad
    @Test
    void shouldFailWhenAgeIsInvalid() {

        ClsUser user = new ClsUser("Juan", "juan@mail.com", "1234", "Administrator");

        when(userService.opCreateUser(user))
                .thenThrow(new IllegalArgumentException("Invalid age"));

        assertThrows(IllegalArgumentException.class,
                () -> controller.createUser(user));
    }

    // 4. Registro duplicado
    @Test
    void shouldFailWhenUserAlreadyExists() {

        ClsUser user = new ClsUser("Ana", "ana@mail.com", "1234", "USER");

        when(userService.opCreateUser(user))
                .thenThrow(new RuntimeException("User already exists"));

        assertThrows(RuntimeException.class,
                () -> controller.createUser(user));
    }
}
