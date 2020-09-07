package com.example.container_rounduse_marketplace_android.services;

import com.example.container_rounduse_marketplace_android.models.Inbound;
import com.example.container_rounduse_marketplace_android.models.ShippingInfo;
import com.example.container_rounduse_marketplace_android.payload.DefaultResponse;
import com.example.container_rounduse_marketplace_android.payload.ErrorResponse;
import com.example.container_rounduse_marketplace_android.payload.PaginationRequest;
import com.example.container_rounduse_marketplace_android.payload.PaginationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ShippingInfoService {
    @PATCH("qr-token")
    Call<DefaultResponse<ShippingInfo>> editShippingInfoByToken(@Header("Authorization") String authHeader, @Header("Authentication") String token);

    @GET("shipping-info/active")
    Call<ShippingInfo> getShippingInfoAreActive(@Header("Authorization") String authHeader);

    @GET("shipping-info/driver")
    Call<PaginationResponse<ShippingInfo>> getShippingInfosByDriver(@Header("Authorization") String authHeader, @Query("page") int page, @Query("limit") int limit);

    @GET("inbound/container/{id}")
    Call<Inbound> getInboundByContainer(@Header("Authorization") String authHeader, @Path("id") Long id);
}