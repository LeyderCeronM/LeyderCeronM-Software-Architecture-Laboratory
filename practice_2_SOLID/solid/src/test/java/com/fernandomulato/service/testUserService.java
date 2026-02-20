package com.fernandomulato.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fernandomulato.model.ClsUser;
import com.fernandomulato.repository.FakeUserRepository;
import com.fernandomulato.service.impl.ClsUserServiceImpl;

class testUserService {

  private FakeUserRepository fakeRepository;
  private IUserService userService = new ClsUserServiceImpl(fakeRepository);

  @BeforeEach
  void setUp() {
    fakeRepository = new FakeUserRepository();
    userService = new ClsUserServiceImpl(fakeRepository);
  }

  // 1. Registro exitoso
  @Test
  void shouldCreateUserSuccessfully() {

    ClsUser user = new ClsUser();
    user.setAttUsername("fernando");
    user.setAttEmail("test@mail.com");
    user.setAttPassword("1234");
    user.setAttRole("USER");
    user.setAttProfession("Engineer");

    ClsUser result = userService.opCreateUser(user);

    assertNotNull(result);
    assertEquals("fernando", result.getAttUsername());
    assertTrue(result.getAttId() > 0);
  }

  // 2. Registro inválido por obligatoriedad (username vacío)
  @Test
  void shouldThrowExceptionWhenUsernameIsEmpty() {

    ClsUser user = new ClsUser();
    user.setAttUsername("");

    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> userService.opCreateUser(user));

    assertEquals("Username is empty", exception.getMessage());
  }

  // 3. Registro duplicado
  @Test
  void shouldThrowExceptionWhenUserIsDuplicated() {

    ClsUser user1 = new ClsUser();
    user1.setAttUsername("fernando");
    user1.setAttEmail("a@mail.com");
    user1.setAttPassword("123");

    userService.opCreateUser(user1);

    ClsUser user2 = new ClsUser();
    user2.setAttUsername("fernando"); 
    user2.setAttEmail("b@mail.com");
    user2.setAttPassword("456");

    assertThrows(
        IllegalArgumentException.class,
        () -> userService.opCreateUser(user2));
  }

  // 4. Update usuario inexistente
  @Test
  void shouldReturnFalseWhenUpdatingNonExistingUser() {

    ClsUser user = new ClsUser();
    user.setAttUsername("nuevo");

    boolean result = userService.opUpdateUser(user, 999);

    assertFalse(result);
  }

  // 5. Delete usuario inexistente
  @Test
  void shouldReturnFalseWhenDeletingNonExistingUser() {

    boolean result = userService.opDeleteUser(999);

    assertFalse(result);
  }

}
