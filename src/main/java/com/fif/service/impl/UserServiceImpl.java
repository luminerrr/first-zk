package com.fif.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fif.Users;
import com.fif.model.User;
import com.fif.service.UserService;

public class UserServiceImpl implements UserService {
    private List<User> users = Users.users;

    // public UserServiceImpl() {
    // users.add(new User("Mark", "male", LocalDate.of(2020, 1, 8), "IT"));
    // users.add(new User("John", "male", LocalDate.of(2020, 1, 8), "IT"));
    // users.add(new User("Jay", "male", LocalDate.of(2020, 1, 8), "IT"));
    // users.add(new User("Lena", "male", LocalDate.of(2020, 1, 8), "IT"));
    // users.add(new User("Tar", "male", LocalDate.of(2020, 1, 8), "IT"));
    // users.add(new User("Mark", "male", LocalDate.of(2020, 1, 8), "IT"));
    // }

    @Override
    public void saveUser(User user) {
        users.add(user);
        return;
    }

    @Override
    public List<User> findByName(String name) {
        List<User> result = new ArrayList<User>();
        if (name.equals("") || name == null) {
            return users;
        }

        for (User user : users) {
            if (user.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(user);
            }
        }

        return result;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void deleteUser(String id) {
        users.removeIf(user -> user.getId().equals(id));

        return;
    }

    @Override
    public User getById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void updateUser(User user) {
        this.deleteUser(user.getId());
        this.saveUser(user);
        return;
    }
}
