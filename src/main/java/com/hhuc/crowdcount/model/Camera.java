package com.hhuc.crowdcount.model;

import lombok.Data;

import java.util.Date;

@Data
public class Camera {
    private int camera_id;
    private String camera_place;
    private String user_id;

    //摄像头的附属信息
    private Date time;//最后的通信时间
    private String user_name;
    private String user_phone;

}
