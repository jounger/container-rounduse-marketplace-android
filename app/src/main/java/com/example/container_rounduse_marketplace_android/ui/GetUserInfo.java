package com.example.container_rounduse_marketplace_android.ui;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import com.example.container_rounduse_marketplace_android.Constrains.Constrains;
import com.example.container_rounduse_marketplace_android.R;
import com.example.container_rounduse_marketplace_android.models.LoginResponse;
import com.example.container_rounduse_marketplace_android.services.LocationService;
import com.example.container_rounduse_marketplace_android.until.ApiClient;
import com.example.container_rounduse_marketplace_android.models.Driver;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetUserInfo extends MainActivity {

    private static final int REQUEST_CODE_LOCATION_PERMISSION = 1;

    private static final String TAG = null;
    private FusedLocationProviderClient mFusedLocationProviderClient;

    public static Long geoId;
    Button logout;
    TextView username, userphone, role;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);

        khaiBao();
        Intent intent = getIntent();
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        authenGetInfo();
        getLastKnownLocation();
        bottomMenuControl();

    }

    public void khaiBao(){
        username = findViewById(R.id.textName);
        userphone = findViewById(R.id.textPhone);
        role = findViewById(R.id.textRole);
        logout = findViewById(R.id.btnLogout);
    }

    public void logout(){

    }

    public void bottomMenuControl(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.user);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.tracking:
                        startActivity(new Intent(getApplicationContext(), TrackingSupply.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.packing:
                        startActivity(new Intent(getApplicationContext(), PackControl.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.user:
                        return true;
                }
                return false;
            }
        });
    }


    public void authenGetInfo() {
        //Call login response to get user info
        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().authToken("Bearer " + token);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse loginResponseCall = response.body();

                String passUsername = loginResponseCall.getUserInfo().getUsername();
                String passPhone = loginResponseCall.getUserInfo().getPhone();
                Integer passID = loginResponseCall.getUserInfo().getId();
                List<String> passRole = loginResponseCall.getUserInfo().getRoles();
                userphone.setText("Phone: " + passPhone);
                role.setText("Role: " + passRole);

                //Call driver to get driver info
                Call<Driver> userCall = ApiClient.getUserService().getDriverById("Bearer " + token, passID);
                userCall.enqueue(new Callback<Driver>() {
                    @Override
                    public void onResponse(Call<Driver> call, Response<Driver> response) {
                        Driver driver = response.body();
                        String driverFullName = driver.getFullname();
                        geoId = driver.getLocation().getId();
                        username.setText("Name: " + driverFullName);
                    }

                    @Override
                    public void onFailure(Call<Driver> call, Throwable t) {
                        Toast.makeText(GetUserInfo.this, "Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

                    }
                });
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(GetUserInfo.this, "Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getLastKnownLocation() {
        if (ContextCompat.checkSelfPermission(
                getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    GetUserInfo.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_CODE_LOCATION_PERMISSION
            );
        } else {
            startLocationService();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_LOCATION_PERMISSION && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startLocationService();
            } else {
                Toast.makeText(this, "Permission Denied!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean isLocationServiceRunning() {
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager != null) {
            for (ActivityManager.RunningServiceInfo service :
                    activityManager.getRunningServices(Integer.MAX_VALUE)) {
                if (LocationService.class.getName().equals(service.service.getClassName())) {
                    if (service.foreground) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    private void startLocationService() {
        if (!isLocationServiceRunning()) {
            Intent intent = new Intent(getApplicationContext(), LocationService.class);
            intent.setAction(Constrains.ACTION_START_LOCATION_SERVICE);
            startService(intent);
            Toast.makeText(this, "Location service started", Toast.LENGTH_SHORT).show();
        }
    }

}