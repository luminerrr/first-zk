package com.fif.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.fif.entity.User;
import com.fif.repository.UserRepository;
import com.fif.service.UserService;

@Service("userService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
        return;
    }

    @Override
    public List<User> findByName(String name) {
        List<User> result = new ArrayList<User>();
        
        // if (name.equals("") || name == null) {
        // return users;
        // }

        // for (User user : users) {
        // if (user.getName().toLowerCase().contains(name.toLowerCase())) {
        // result.add(user);
        // }
        // }

        return result;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteUserById(id);
        return;
    }

    @Override
    public User getById(Integer id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.editUser(user);
        return;
    }
}
