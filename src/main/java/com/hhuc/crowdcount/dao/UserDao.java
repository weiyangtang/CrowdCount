package com.hhuc.crowdcount.dao;

import com.hhuc.crowdcount.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("SELECT * FROM `user`")
    List<User> getAllUsers();

    @Select("SELECT * FROM `user` WHERE user_id=#{user_id}")
    User getUserById(String user_id);

    @Insert("INSERT INTO user(user_id,user_password,user_name,user_phone,user_sex,user_age) VALUES(#{user_id},#{user_password},#{user_name},#{user_phone},#{user_sex},#{user_age})")
    int insertUser(User user);
}
