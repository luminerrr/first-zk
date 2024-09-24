package com.fif.model;

import java.time.LocalDate;

public class User {
    private String name;
    private String gender;
    private LocalDate birthday;
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public User(String name, String gender, LocalDate birthday, String job) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.job = job;
    }
}
