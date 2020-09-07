package com.example.container_rounduse_marketplace_android.services;

import android.content.res.Resources;

import com.example.container_rounduse_marketplace_android.models.Driver;
import com.example.container_rounduse_marketplace_android.models.GeoLocation;
import com.example.container_rounduse_marketplace_android.models.Inbound;
import com.example.container_rounduse_marketplace_android.models.LoginRequest;
import com.example.container_rounduse_marketplace_android.models.LoginResponse;
import com.example.container_rounduse_marketplace_android.models.ShippingInfo;
import com.example.container_rounduse_marketplace_android.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {
    @POST("auth/signin/")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

    @GET("auth/user?=")
    Call<LoginResponse> authToken(@Header("Authorization") String authHeader);

    @GET("driver/{id}")
    Call<Driver> getDriverById(@Header("Authorization") String authHeader, @Path("id") Integer id);

    @PATCH("geolocation/{id}")
    Call<GeoLocation> editGeolocation(@Header("Authorization") String authHeader, @Path("id") Long id, @Body GeoLocation geoLocation);




}
