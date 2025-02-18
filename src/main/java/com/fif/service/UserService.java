package com.fif.service;

import java.util.List;

import com.fif.model.User;

public interface UserService {
    void saveUser(User user);

    List<User> getAllUsers();

    List<User> findByName(String name);

}
