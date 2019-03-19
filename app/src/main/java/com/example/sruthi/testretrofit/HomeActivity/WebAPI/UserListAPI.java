package com.example.sruthi.testretrofit.HomeActivity.WebAPI;

import com.example.sruthi.testretrofit.HomeActivity.Model.UserResultModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserListAPI {
    @FormUrlEncoded
    @POST("service.php")
    Call<UserResultModel> getValues(@Field("func") String func, @Field("userid") String userid);
}
