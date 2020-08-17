package com.example.container_rounduse_marketplace_android.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.container_rounduse_marketplace_android.until.ApiClient;
import com.example.container_rounduse_marketplace_android.R;
import com.example.container_rounduse_marketplace_android.models.LoginRequest;
import com.example.container_rounduse_marketplace_android.models.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://192.168.2.101:8085/api/auth/").addConverterFactory(GsonConverterFactory.create());

    EditText username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = findViewById(R.id.textUsername);
        password = findViewById(R.id.textPassword);
        btnLogin = findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Username  / Password Required", Toast.LENGTH_LONG).show();

                } else {
                    //proceed to login
                    login();
                }
            }
        });

    }

    public static String token;

    public void login() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    token = response.body().getData().getIdToken();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (!response.body().getData().getUserInfo().getRoles().iterator().next().equals("ROLE_DRIVER")) {
                                Toast.makeText(MainActivity.this, "Only Driver can use this app", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(MainActivity.this, GetUserInfo.class));
                            }
                        }
                    }, 700);
                } else {
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}