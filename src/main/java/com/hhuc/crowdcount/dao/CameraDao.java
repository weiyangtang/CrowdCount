package com.hhuc.crowdcount.dao;

import com.hhuc.crowdcount.model.Camera;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CameraDao {

    @Select("SELECT * FROM camera")
    public List<Camera> getAllCameras();

    @Select("SELECT * FROM camera WHERE camera_id=#{camera_id}")
    public Camera getCameraById(int camera_id);


    @Insert("INSERT INTO camera(camera_place) VALUES(#{camera_place})")
    public int insertCamera(Camera camera);

    @Select("SELECT camera.camera_id,camera.camera_place,camera.max_num,user.user_id,user.user_name,user.user_phone,cameraPhoto.time FROM camera,user,(SELECT * FROM camera_people_num  ORDER BY time desc LIMIT 1) as cameraPhoto \n" +
            "WHERE camera.camera_id=cameraPhoto.camera_id and camera.camera_id=#{camera_id} and user.user_id=camera.user_id")
    public List<Camera> getCameraInfById(int camera_id);


    @Select("SELECT camera.camera_id,camera.camera_place,camera.max_num,user.user_id,user.user_name,user.user_phone FROM camera,user WHERE camera.user_id=user.user_id")
    public List<Camera> getCameraInfo();


}
