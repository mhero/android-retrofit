package com.mac.cv.network;

import com.mac.cv.model.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface GetDataService {

    @GET("/cv")
    Call<List<Event>> getAllPhotos();
}
