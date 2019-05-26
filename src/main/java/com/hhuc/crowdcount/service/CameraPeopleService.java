package com.hhuc.crowdcount.service;

import com.hhuc.crowdcount.dao.CameraDao;
import com.hhuc.crowdcount.dao.CameraPeopleDao;
import com.hhuc.crowdcount.model.Camera_people_num;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraPeopleService {
    @Autowired
    CameraPeopleDao cameraPeopleDao;

    public List<Camera_people_num> getAllcamera_people_nums() {
        return cameraPeopleDao.getAllcamera_people_nums();
    }


    public List<Camera_people_num> getCamera_people_numById(int camera_id) {
        return cameraPeopleDao.getCamera_people_numById(camera_id);
    }


    public List<Camera_people_num> getTopCamera_people_numById(int camera_id, int topN) {
        return cameraPeopleDao.getTopCamera_people_numById(camera_id, topN);
    }


    public int insertcamera_people(Camera_people_num camera_people_num) {
        return cameraPeopleDao.insertcamera_people(camera_people_num);
    }

}
