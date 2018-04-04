package com.example.suyesh.minotech.Models;

/**
 * Created by SUYESH on 3/30/2018.
 */

public class VideosModel {
    private String info,image,video_id;

    public VideosModel(String info, String image , String video_id) {
        this.info = info;
        this.image = image;
        this.video_id = video_id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }
}
