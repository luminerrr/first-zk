package com.fif.viewmodel;

import java.time.LocalDate;
import java.util.Date;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import com.fif.entity.User;
import com.fif.service.UserService;
import com.fif.utils.DateUtils;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@VariableResolver(DelegatingVariableResolver.class)
public class EditViewModel {
    private Integer userId;
    private String username;
    private String gender;
    private Date birthday;
    private String jobs;

    @WireVariable
    UserService userService;
    DateUtils dateUtils = new DateUtils();

    @Init
    public void init() {
        this.userId = Integer.parseInt(Executions.getCurrent().getParameter("id"));
        if (this.userId == null) {
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
        LocalDate birthdayLocalDate = dateUtils.convertToLocalDateViaInstant(birthday);
        User user = new User();
        user.setName(username);
        user.setBirthday(birthdayLocalDate);
        user.setGender(gender);
        user.setJob(jobs);
        user.setId(userId);
        userService.updateUser(user);
        Executions.sendRedirect("table.zul");
        return;
    }
}
