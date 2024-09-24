package com.fif.viewmodel;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;

import com.fif.model.User;
import com.fif.service.UserService;
import com.fif.service.impl.UserServiceImpl;
import com.fif.utils.DateUtils;

public class RegistrationViewModel {
    private String username;
    private String gender;
    private Date birthday;
    private String jobs;

    UserService userService = new UserServiceImpl();
    UserViewmodel userViewmodel = new UserViewmodel();

    // Utils
    DateUtils dateUtils = new DateUtils();

    @Command
    public void submitForm() {
        LocalDate birthLocalDate = dateUtils.convertToLocalDateViaInstant(birthday);
        User newUser = new User(UUID.randomUUID().toString(), username, gender, birthLocalDate, jobs);
        userService.saveUser(newUser);
        userViewmodel.dataUser.clear();
        userViewmodel.dataUser.addAll(userService.getAllUsers());
        Executions.sendRedirect("/table.zul");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

}
