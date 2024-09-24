package com.fif.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModelList;

import com.fif.Users;
import com.fif.model.User;
import com.fif.service.UserService;
import com.fif.service.impl.UserServiceImpl;

public class UserViewmodel {
    private String keyword;

    public ListModelList<User> dataUser = new ListModelList<>();
    private UserService userService = new UserServiceImpl();

    @Init
    public void init() {
        dataUser.addAll(Users.users);
    }

    @Command
    public void searchByName() {
        List<User> users = userService.findByName(keyword);
        dataUser.clear();
        System.out.println(users);
        dataUser.addAll(users);
    }

    @Command
    public void deleteUser(@BindingParam("id") String id) {
        userService.deleteUser(id);
        dataUser.clear();
        dataUser.addAll(Users.users);
    }

    @Command
    public void redirectEdit(@BindingParam("id") String id) {
        Executions.sendRedirect("/edit.zul?id=" + id);
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public ListModelList<User> getDataUser() {
        return dataUser;
    }

    public void setDataUser(ListModelList<User> dataUser) {
        this.dataUser = dataUser;
    }

}
