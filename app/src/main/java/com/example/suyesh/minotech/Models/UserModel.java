package com.example.suyesh.minotech.Models;

/**
 * Created by SUYESH on 3/14/2018.
 */

public class UserModel {
private String name,gender,job;

    public UserModel(String name, String gender, String job) {
        this.name = name;
        this.gender = gender;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
