package com.fif.controller;

import java.time.LocalDate;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

import com.fif.model.User;
import com.fif.service.UserService;
import com.fif.service.impl.UserServiceImpl;
import com.fif.utils.DateUtils;

public class RegistrationController extends SelectorComposer<Component> {
    @Wire
    private Button submitForm;

    // Forms
    @Wire
    private Textbox username;

    @Wire
    private Radiogroup gender;

    @Wire
    Datebox birthday;

    @Wire
    Combobox jobs;

    private DateUtils dateUtils = new DateUtils();
    private UserService userService = new UserServiceImpl();
    private UserController userController = new UserController();

    @Listen("onClick = #submitForm")
    public void submitForm() {
        String username = this.username.getValue();
        String gender = this.gender.getSelectedItem().getValue();
        LocalDate birthday = dateUtils.convertToLocalDateViaInstant(this.birthday.getValue());
        String job = this.jobs.getSelectedItem().getValue();
        
        User newUser = new User(username, gender, birthday, job);

        userService.saveUser(newUser);
        userController.dataUser.clear();
        userController.dataUser.addAll(userService.getAllUsers());
        Executions.sendRedirect("/table.zul");
        System.out.println(userController.dataUser.size());
    }
}
