package com.hhuc.crowdcount.service;

import com.hhuc.crowdcount.dao.UserDao;
import com.hhuc.crowdcount.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public boolean login(User user) {
        if (user == null)
            return false;
        else {
            User loginUser = userDao.getUserById(user.getUser_id());
            if (loginUser != null && loginUser.getUser_password().equals(user.getUser_password()))
                return true;
            return false;
        }
    }

    public User getUserById(String user_id) {
        return userDao.getUserById(user_id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


}
