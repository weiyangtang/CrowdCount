package com.hhuc.crowdcount.controller;

import com.hhuc.crowdcount.model.User;
import com.hhuc.crowdcount.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/user/list"}, method = RequestMethod.GET)
    public String userListPage() {
        return "user/userList";
    }

    @RequestMapping(value = {"/user/list"}, method = RequestMethod.POST)
    @ResponseBody
    public List<User> getUserList() {
        return userService.getAllUsers();
    }


}
