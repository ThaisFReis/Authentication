package com.authentication.service;

import com.authentication.repository.userRepository;
import com.authentication.model.userModel;

public class userService {
    public static void createUser(String email, String name, String password) throws Exception {
        userModel user = new userModel();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        userRepository.createUser(user);
    }

    public static userModel updateUser(int id, String email, String name, String password) throws Exception {
        userModel user = new userModel();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setId(id);
        return userRepository.updateUser(user);
    }

    public static void deleteUser(int id) throws Exception {
        userRepository.deleteUser(id);
    }

    public static userModel getUserById(int id){
        return userRepository.getUserById(id);
    }

    public static userModel getUserByEmail(String email) throws Exception {
        return userRepository.getUserByEmail(email);
    }

    public static userModel getAllUsers(){
        return userRepository.getAllUsers();
    }
}
