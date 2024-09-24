package com.fif;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fif.model.User;

public class Users {
    public static List<User> users = new ArrayList<User>();

    static {
        users.add(new User(UUID.randomUUID().toString(), "Mark", "male", LocalDate.of(2020, 1, 8), "IT"));
        users.add(new User(UUID.randomUUID().toString(), "John", "male", LocalDate.of(2020, 1, 8), "IT"));
        users.add(new User(UUID.randomUUID().toString(), "Jay", "male", LocalDate.of(2020, 1, 8), "IT"));
        users.add(new User(UUID.randomUUID().toString(), "Lena", "male", LocalDate.of(2020, 1, 8), "IT"));
        users.add(new User(UUID.randomUUID().toString(), "Tar", "male", LocalDate.of(2020, 1, 8), "IT"));
        users.add(new User(UUID.randomUUID().toString(), "Mark", "male", LocalDate.of(2020, 1, 8), "IT"));
    }
}
