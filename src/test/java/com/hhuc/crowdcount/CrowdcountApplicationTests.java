package com.hhuc.crowdcount;

import com.hhuc.crowdcount.dao.CameraPeopleDao;
import com.hhuc.crowdcount.dao.UserDao;
import com.hhuc.crowdcount.model.Camera;
import com.hhuc.crowdcount.model.Camera_people_num;
import com.hhuc.crowdcount.model.User;
import com.hhuc.crowdcount.service.CameraService;
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

    @Autowired
    CameraPeopleDao cameraPeopleDao;

    @Autowired
    CameraService cameraService;

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

    @Test
    public void testCameraPeopleDao() {
        List<Camera_people_num> camera_people_nums = cameraPeopleDao.getAllcamera_people_nums();
        for (Camera_people_num camera_people_num : camera_people_nums) {
            System.out.println(camera_people_num);
        }
        System.out.println("***************************************************");
        camera_people_nums = cameraPeopleDao.getTopCamera_people_numById(1, 3);
        for (Camera_people_num camera_people_num : camera_people_nums) {
            System.out.println(camera_people_num);
        }
    }


    @Test
    public void testCameraByIDDao() {
        List<Camera> cameras=cameraService.getAllCameraInfo();
        for (Camera camera : cameras) {
            System.out.println(camera);
        }

    }



}
