package com.hhuc.crowdcount.model;

import lombok.Data;

@Data
public class User {
    private String user_id;
    private String user_name;
    private String user_password;
    private int user_age;
    private String user_phone;
    private String user_sex;
    private String user_email;

}
