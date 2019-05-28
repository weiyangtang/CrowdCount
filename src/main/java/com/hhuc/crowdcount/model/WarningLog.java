package com.hhuc.crowdcount.model;

import lombok.Data;

import java.util.Date;

@Data
public class WarningLog {
    private int camera_id;
    private String user_email;
    private Date send_time;
    //user
    private String user_name;
    private String camera_place;

}
