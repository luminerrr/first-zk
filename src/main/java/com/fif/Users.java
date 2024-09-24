package com.fif;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fif.model.User;

public class Users {
    public static List<User> users = new ArrayList<User>();

    static {
        users.add(new User("Mark", "male", LocalDate.of(2020, 1, 8), "IT"));
        users.add(new User("John", "male", LocalDate.of(2020, 1, 8), "IT"));
        users.add(new User("Jay", "male", LocalDate.of(2020, 1, 8), "IT"));
        users.add(new User("Lena", "male", LocalDate.of(2020, 1, 8), "IT"));
        users.add(new User("Tar", "male", LocalDate.of(2020, 1, 8), "IT"));
        users.add(new User("Mark", "male", LocalDate.of(2020, 1, 8), "IT"));
    }
}
