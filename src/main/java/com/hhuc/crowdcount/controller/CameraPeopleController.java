package com.hhuc.crowdcount.controller;

import com.hhuc.crowdcount.dao.CameraPeopleDao;
import com.hhuc.crowdcount.model.Camera_people_num;
import com.hhuc.crowdcount.service.CameraPeopleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CameraPeopleController {

    @Autowired
    CameraPeopleService cameraPeopleService;

    @RequestMapping(value = "CameraPeople/allList", method = RequestMethod.GET)
    public String CameraPeopleAllListPage() {
        return "/camera/CameraPeopleAllListPage";
    }

    @RequestMapping(value = "CameraPeople/allList", method = RequestMethod.POST)
    @ResponseBody
    public List<Camera_people_num> CameraPeopleAllListPost(@RequestParam("camera_id") int camera_id, @RequestParam("top_num") int top_num) {
        return cameraPeopleService.getTopCamera_people_numById(camera_id, top_num);
    }


}
