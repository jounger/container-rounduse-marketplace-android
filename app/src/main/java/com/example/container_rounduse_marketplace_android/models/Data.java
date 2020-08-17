package com.example.container_rounduse_marketplace_android.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("id_token")
    @Expose
    private String idToken;
    @SerializedName("userInfo")
    @Expose
    private User userInfo;

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "idToken='" + idToken + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
