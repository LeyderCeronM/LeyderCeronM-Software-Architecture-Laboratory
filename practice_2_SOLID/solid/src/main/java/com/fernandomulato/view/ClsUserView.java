package com.fernandomulato.view;

import java.util.Scanner;

import com.fernandomulato.controller.ClsUserController;
import com.fernandomulato.model.ClsUser;

public class ClsUserView {

  private final ClsUserController controller;
  private final Scanner scanner;

  public ClsUserView(ClsUserController controller) {
    this.controller = controller;
    this.scanner = new Scanner(System.in);
  }

  public void start() {

    while (true) {

      System.out.println("\n==== USER MENU ====");
      System.out.println("1. Create user");
      System.out.println("2. Get user");
      System.out.println("3. Delete user");
      System.out.println("4. Exit");
      System.out.print("Choose option: ");

      int option = scanner.nextInt();
      scanner.nextLine();

      switch (option) {
        case 1 -> createUser();
        case 2 -> getUser();
        case 3 -> deleteUser();
        case 4 -> {
          System.out.println("Bye 👋");
          return;
        }
        default -> System.out.println("Invalid option");
      }
    }
  }

  private void createUser() {

    System.out.print("Username: ");
    String username = scanner.nextLine();

    System.out.print("Email: ");
    String email = scanner.nextLine();

    System.out.print("Password: ");
    String password = scanner.nextLine();

    ClsUser user = new ClsUser(username, email, password, "Administrator");

    ClsUser created = controller.createUser(user);

    if (created != null) {
      System.out.println("User created with ID: " + created.getAttId());
    } else {
      System.out.println("Error creating user");
    }
  }

  private void getUser() {

    System.out.print("User ID: ");
    long id = scanner.nextLong();
    scanner.nextLine();

    ClsUser user = controller.getUserById(id);

    if (user != null) {
      System.out.println("Username: " + user.getAttUsername());
      System.out.println("Email: " + user.getAttEmail());
    } else {
      System.out.println("User not found");
    }
  }

  private void deleteUser() {

    System.out.print("User ID: ");
    long id = scanner.nextLong();
    scanner.nextLine();

    boolean deleted = controller.deleteUser(id);

    if (deleted) {
      System.out.println("User deleted");
    } else {
      System.out.println("User not found");
    }
  }
}
