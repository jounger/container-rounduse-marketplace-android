package com.example.container_rounduse_marketplace_android.until;

import android.widget.Toast;

import com.example.container_rounduse_marketplace_android.models.ShippingInfo;
import com.example.container_rounduse_marketplace_android.services.ShippingInfoService;
import com.example.container_rounduse_marketplace_android.services.UserService;
import com.example.container_rounduse_marketplace_android.ui.PackControl;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private  static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
//        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
//            @NotNull
//            @Override
//            public Response intercept(@NotNull Chain chain) throws IOException {
//                Request request = chain.request();
//                Response response = chain.proceed(request);
//
//                if (response != null && !response.isSuccessful() && response.body() != null) {
//                    Converter<ResponseBody, BasicResponse> errorConverter =
//                            MyApplication.getRestClient().getRetrofitInstance().responseConverter(BasicResponse.class, new Annotation[0]);
//                    BasicResponse error = errorConverter.convert(response.errorBody());
//                    //DO ERROR HANDLING HERE
//                    return;
//                }
//                return null;
//            }
//        }).build();


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.56.1:8085/api/")
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public static UserService getUserService(){
        UserService userService = getRetrofit().create(UserService.class);
        return  userService;
    }

    public static ShippingInfoService getShippingInfoService(){
        ShippingInfoService shippingInfoService = getRetrofit().create(ShippingInfoService.class);
        return shippingInfoService;
    }
}
