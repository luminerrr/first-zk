package com.fif.viewmodel;

import java.time.LocalDate;
import java.util.Date;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import com.fif.entity.User;
import com.fif.service.UserService;
import com.fif.service.impl.UserServiceImpl;
import com.fif.utils.DateUtils;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class RegistrationViewModel {
    private String username;
    private String gender;
    private Date birthday;
    private String jobs;

    @WireVariable
    UserService userService = new UserServiceImpl();

    UserViewmodel userViewmodel = new UserViewmodel();

    // Utils
    DateUtils dateUtils = new DateUtils();

    @Command
    public void submitForm() {
        LocalDate birthLocalDate = dateUtils.convertToLocalDateViaInstant(birthday);
        User newUser = new User();
        newUser.setName(username);
        newUser.setBirthday(birthLocalDate);
        newUser.setGender(gender);
        newUser.setJob(jobs);
        userService.saveUser(newUser);
        Executions.sendRedirect("/table.zul");
    }

    @Command
    public void resetButton() {

    }
}
