package com.hhuc.crowdcount.controller;

import com.hhuc.crowdcount.model.Camera;
import com.hhuc.crowdcount.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CameraController {
    @Autowired
    CameraService cameraService;


    @RequestMapping(value = "/camera/allList", method = RequestMethod.GET)
    public String getAllCameraInfoPage() {
        return "camera/CameraList";
    }

    @RequestMapping(value = "/camera/allList", method = RequestMethod.POST)
    @ResponseBody
    public List<Camera> getAllCameraInfo() {
        return cameraService.getAllCameraInfo();
    }

    /**
     * 摄像头的地址
     */
    @RequestMapping(value = "/camera/cameraLocation", method = RequestMethod.GET)
    public String CameraLocationPage() {
        return "camera/cameraLocation";
    }


}
