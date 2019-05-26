package com.hhuc.crowdcount.model;

import lombok.Data;

import java.util.Date;

@Data
public class Login_log {
    private String user_id;
    private Date login_time;
    private String login_gps;
    private String login_ip;
}
