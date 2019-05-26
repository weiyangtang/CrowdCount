package com.hhuc.crowdcount.dao;

import com.hhuc.crowdcount.model.Camera_people_num;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CameraPeopleDao {

    @Select("SELECT * FROM camera_people_num")
    public List<Camera_people_num> getAllcamera_people_nums();

    @Select("SELECT * FROM camera_people_num WHERE camera_id=#{camera_id}")
    public List<Camera_people_num> getCamera_people_numById(int camera_id);

    @Select("SELECT * FROM (SELECT * FROM camera_people_num WHERE camera_id=#{camera_id} ORDER BY time desc LIMIT #{topN}) var ORDER BY time")
    public List<Camera_people_num> getTopCamera_people_numById(int camera_id, int topN);


    @Insert("INSERT INTO camera_people_num(camera_id,num,time) VALUES(#{camera_id},#{num},#{time})")
    public int insertcamera_people(Camera_people_num camera_people_num);



}
