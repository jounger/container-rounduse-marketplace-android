package com.example.container_rounduse_marketplace_android.services;

import com.example.container_rounduse_marketplace_android.models.ShippingInfo;
import com.example.container_rounduse_marketplace_android.payload.DefaultResponse;
import com.example.container_rounduse_marketplace_android.payload.ErrorResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface ShippingInfoService {
    @PATCH("qr-token")
    Call<DefaultResponse<ShippingInfo>> editShippingInfoByToken(@Header("Authorization") String authHeader, @Header("Authentication") String token);

    @GET("shipping-info/driver")
    Call<ShippingInfo>  getShippingInfosByDriver(@Header("Authorization") String authHeader, @Header("page") int page, @Header("limit") int limit);
}
