package com.fif.viewmodel;

import java.util.Date;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;

import com.fif.model.User;
import com.fif.service.UserService;
import com.fif.service.impl.UserServiceImpl;
import com.fif.utils.DateUtils;

public class EditViewModel {
    private String userId = "";
    private String username;
    private String gender;
    private Date birthday;
    private String jobs;

    UserService userService = new UserServiceImpl();
    DateUtils dateUtils = new DateUtils();

    @Init
    public void init() {
        this.userId = Executions.getCurrent().getParameter("id");
        if (this.userId == null || this.userId.isEmpty()) {
            Executions.sendRedirect("hello-world.zul");
            return;
        }
        User selectedUser = userService.getById(userId);
        if (selectedUser == null)
            throw new RuntimeException("Please go through from Table");

        this.setUsername(selectedUser.getName());
        this.setGender(selectedUser.getGender());
        this.setBirthday(dateUtils.convertToDateViaInstant(selectedUser.getBirthday()));
        this.setJobs(selectedUser.getJob());
    }

    @Command
    public void updateUser() {
        User updatedUser = new User(userId, username, gender, dateUtils.convertToLocalDateViaInstant(birthday), jobs);
        userService.updateUser(updatedUser);
        Executions.sendRedirect("table.zul");
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
