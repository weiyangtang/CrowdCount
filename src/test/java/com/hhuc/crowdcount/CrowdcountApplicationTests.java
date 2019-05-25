package com.hhuc.crowdcount;

import com.hhuc.crowdcount.dao.UserDao;
import com.hhuc.crowdcount.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrowdcountApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    public void contextLoads() {
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUser_id("166371088");
        user.setUser_name("boss");
        user.setUser_password("543216");
        user.setUser_phone("15942303297");
        user.setUser_sex("男");
        user.setUser_age(50);
        int res = userDao.insertUser(user);
        if (res > 0)
            System.out.println("插入成功");
        else
            System.out.println("插入失败");

    }

}
