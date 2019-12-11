package com.example.booklapangan.apihelper;

import com.example.booklapangan.model.ResponseCategory;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseApiService {

    @GET("category")
    Call<ResponseCategory> getCategory();

    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> loginRequest(@Field("email") String email,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> registerRequest(@Field("name") String name,
                                       @Field("email") String email,
                                       @Field("password") String password,
                                       @Field("c_password") String c_password);

    @FormUrlEncoded
    @POST("edit")
    Call<ResponseBody> editRequest( @Field("id") String id,
                                    @Field("name") String name,
                                    @Field("email") String email);

}
