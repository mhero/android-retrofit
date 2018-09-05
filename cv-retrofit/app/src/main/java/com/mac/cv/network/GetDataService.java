package com.mac.cv.network;

import com.mac.cv.model.AccountCredentials;
import com.mac.cv.model.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface GetDataService {

    @GET("/cv")
    Call<List<Event>> getAllEvents(@Header("Authorization") String authKey);

    @POST("/login")
    Call<Void> geToken(@Body AccountCredentials body);
}
