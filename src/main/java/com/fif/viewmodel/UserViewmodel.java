package com.fif.viewmodel;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import com.fif.entity.User;
import com.fif.service.UserService;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class UserViewmodel {
    private String keyword;

    public ListModelList<User> dataUser = new ListModelList<>();
    
    @WireVariable
    private UserService userService;

    @Init
    public void init() {
        List<User> allUsers = userService.getAllUsers();
        if(allUsers.isEmpty()) allUsers = new ArrayList<>();
        System.out.println(allUsers);
        dataUser.addAll(userService.getAllUsers());
    }

    @Command
    public void searchByName() {
        List<User> users = userService.findByName(keyword);
        dataUser.clear();
        System.out.println(users);
        dataUser.addAll(users);
    }

    @Command
    public void deleteUser(@BindingParam("id") Integer id) {
        userService.deleteUser(id);
        refreshUser();
    }

    @Command
    public void redirectEdit(@BindingParam("id") String id) {
        Executions.sendRedirect("/edit.zul?id=" + id);
    }

    private void refreshUser() {
        dataUser.clear();
        dataUser.addAll(userService.getAllUsers());
    }
}
