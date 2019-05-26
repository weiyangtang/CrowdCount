package com.hhuc.crowdcount.service;

import com.hhuc.crowdcount.dao.CameraDao;
import com.hhuc.crowdcount.model.Camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraService {
    @Autowired
    CameraDao cameraDao;

    public List<Camera> getAllCameras() {
        return cameraDao.getAllCameras();
    }

    public Camera getCameraById(int camera_id) {
        return cameraDao.getCameraById(camera_id);
    }

    public int insertCamera(Camera camera) {
        return cameraDao.insertCamera(camera);
    }

    public List<Camera> getAllCamerasById(int camera_id) {
        return cameraDao.getCameraInfById(camera_id);
    }

    public List<Camera> getAllCameraInfo(){
        return cameraDao.getCameraInfo();
    }

}
