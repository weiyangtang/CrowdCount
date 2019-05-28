package com.hhuc.crowdcount.dao;

import com.hhuc.crowdcount.model.Camera;
import com.hhuc.crowdcount.model.Camera_danger;
import com.hhuc.crowdcount.model.WarningLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface WarningDao {

    @Select("SELECT camera.camera_id,camera.camera_place,user.user_name,user.user_email FROM camera,user,(SELECT camera_id FROM camera_danger WHERE deal = 0 GROUP BY camera_id) as warningCamera WHERE camera.user_id=user.user_id and camera.camera_id=warningCamera.camera_id")
    public List<WarningLog> getAllCameraDangerUserList();

    @Select("SELECT DISTINCT camera_id FROM camera_danger WHERE deal=0")
    public List<Camera_danger> getAllCameraDangerList();


    @Select("SELECT camera.camera_id,camera.camera_place,warninglog.send_time,user.user_name,user.user_email FROM warninglog,camera,user WHERE camera.camera_id=warninglog.camera_id and user.user_id=camera.user_id and warninglog.camera_id=#{camera_id} ORDER BY warninglog.send_time desc LIMIT 1")
    public WarningLog getNewCameraDangerById(int camera_id);

    @Select("SELECT camera.camera_id,camera.camera_place,user.user_name,`user`.user_email FROM camera,`user` WHERE camera.user_id=`user`.user_id and camera.camera_id=#{camera_id}")
    public WarningLog getWarningLogById(int camera_id);

    @Update("UPDATE camera_danger SET deal=1")
    public int updateCameraDanger();

    @Insert("INSERT INTO warninglog(camera_id,user_email,send_time) VALUES(#{camera_id},#{user_email},#{send_time})")
    public int insertwarninglog(WarningLog warningLog);


}
