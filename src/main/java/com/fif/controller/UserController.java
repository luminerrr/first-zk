package com.fif.controller;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;

import com.fif.model.User;
import com.fif.service.UserService;
import com.fif.service.impl.UserServiceImpl;

public class UserController extends SelectorComposer<Component> {
    @Wire
    private Textbox searchUser;

    @Wire
    private Grid userGrid;

    @Wire
    private Button searchButton;

    

    public ListModelList<User> dataUser = new ListModelList<>();
    private UserService userService = new UserServiceImpl();

    public UserController() {
        dataUser.addAll(userService.getAllUsers());
    }

    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        System.out.println("from  doAfterCompose");
        System.out.println(dataUser.size());
        userGrid.setModel(dataUser);
    }

    @Listen("onClick = #searchButton; onOk = vbox")
    public void searchByName() {
        String search = searchUser.getValue();
        List<User> users = userService.findByName(search);
        dataUser.clear();
        System.out.println(users);
        dataUser.addAll(users);
    }

}
