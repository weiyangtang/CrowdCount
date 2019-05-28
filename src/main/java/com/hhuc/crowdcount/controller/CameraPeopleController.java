package com.hhuc.crowdcount.controller;

import com.hhuc.crowdcount.dao.CameraPeopleDao;
import com.hhuc.crowdcount.model.Camera;
import com.hhuc.crowdcount.model.Camera_people_num;
import com.hhuc.crowdcount.service.CameraPeopleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CameraPeopleController {

    @Autowired
    CameraPeopleService cameraPeopleService;

    @RequestMapping(value = "/CameraPeople/CameraRealTime", method = RequestMethod.GET)
    public String CameraPeopleAllListPage() {
        return "/camera/CameraRealTimePage";
    }

    @RequestMapping(value = "/CameraPeople/CameraRealTime", method = RequestMethod.POST)
    @ResponseBody
    public List<Camera_people_num> CameraPeopleAllListPost(@RequestParam("camera_id") int camera_id, @RequestParam("top_num") int top_num) {
        return cameraPeopleService.getTopCamera_people_numById(camera_id, top_num);
    }

    @RequestMapping(value = "/CameraPeople/CameraPhoto", method = RequestMethod.GET)
    public String CameraPhotoPage() {
        return "/camera/CameraPhoto";
    }

    @RequestMapping(value = "/CameraPeople/CameraPhoto", method = RequestMethod.POST)
    @ResponseBody
    public List<Camera_people_num> CameraPhotoPost(@RequestParam("camera_id") int camera_id, @RequestParam("top_num") int top_num) {
        return cameraPeopleService.getTopCamera_people_numById(camera_id, top_num);
    }

    /**
     * 返回所有摄像头的数据变化折线图
     */
    @RequestMapping(value = "/CameraPeople/CameraPeopleData", method = RequestMethod.GET)
    public String CameraPeopleDataPage() {
        return "/camera/CameraPeopleData";
    }

    /**
     * 返回单独摄像头的数据变化折线图
     */
    @RequestMapping(value = "/CameraPeople/CameraPeopleSingleData/{Camera_id}", method = RequestMethod.GET)
    public String CameraPeopleSingleDataPage(Model model, @PathVariable("Camera_id") int Camera_id) {
        Camera camera = new Camera();
        camera.setCamera_id(Camera_id);
        model.addAttribute("camera", camera);
        return "/camera/CameraSingleData";
    }

    @RequestMapping(value = "/CameraPeople/CameraPhotoAll", method = RequestMethod.GET)
    public String CameraPhotoAllPage() {
        return "/camera/CameraPhotoAll";
    }

}
