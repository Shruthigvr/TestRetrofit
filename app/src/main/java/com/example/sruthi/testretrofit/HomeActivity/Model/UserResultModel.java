package com.example.sruthi.testretrofit.HomeActivity.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("userlist")
    @Expose
    private List<UserListDataModel> userlist = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<UserListDataModel> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<UserListDataModel> userlist) {
        this.userlist = userlist;
    }
}
