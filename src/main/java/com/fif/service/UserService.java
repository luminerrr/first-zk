package com.fif.service;

import java.util.List;

import com.fif.entity.User;

public interface UserService {
    void saveUser(User user);

    List<User> getAllUsers();

    List<User> findByName(String name);

    void deleteUser(Integer id);

    User getById(Integer id);

    void updateUser(User user);
}
