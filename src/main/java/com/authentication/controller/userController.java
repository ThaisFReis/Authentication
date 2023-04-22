package com.authentication.controller;

import com.authentication.model.userModel;

public class userController {

    public static void createUser(String email, String name, String password) throws Exception {
        com.authentication.service.userService.createUser(email, name, password);
    }

    public static userModel getUserById(int id) {
        return com.authentication.service.userService.getUserById(id);
    }

    public static userModel getAllUsers() {
        return com.authentication.service.userService.getAllUsers();
    }

    public static userModel updateUser(int id, String email, String name, String password) throws Exception {
        return com.authentication.service.userService.updateUser(id, email, name, password);
    }

    public static void deleteUser(int id) throws Exception {
        com.authentication.service.userService.deleteUser(id);
    }

    public static userModel login(String email, String password) throws Exception {
        userModel user = com.authentication.service.userService.getUserByEmail(email);
        if (user == null) {
            throw new Exception("User not found");
        }
        if (!user.getPassword().equals(password)) {
            throw new Exception("Password is incorrect");
        }
        return user;
    }
}
