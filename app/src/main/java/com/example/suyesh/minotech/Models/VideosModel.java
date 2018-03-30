package com.example.suyesh.minotech.Models;

/**
 * Created by SUYESH on 3/30/2018.
 */

public class VideosModel {
    private String info;
    private int image;

    public VideosModel(String info, int image) {
        this.info = info;
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
