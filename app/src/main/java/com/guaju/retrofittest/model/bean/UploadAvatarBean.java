package com.guaju.retrofittest.model.bean;

/**
 * Created by guaju on 2018/4/13.
 */

public class UploadAvatarBean {
    String status,info;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public UploadAvatarBean(String status, String info) {
        this.status = status;
        this.info = info;
    }

    @Override
    public String toString() {
        return "UploadAvatarBean{" +
                "status='" + status + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
