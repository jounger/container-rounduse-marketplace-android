package com.example.container_rounduse_marketplace_android.ui;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import com.example.container_rounduse_marketplace_android.R;
import com.example.container_rounduse_marketplace_android.models.ShippingInfo;
import com.example.container_rounduse_marketplace_android.payload.DefaultResponse;
import com.example.container_rounduse_marketplace_android.payload.ErrorResponse;
import com.example.container_rounduse_marketplace_android.until.ApiClient;
import com.google.android.gms.common.api.Api;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.zxing.Result;

import java.util.ArrayList;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.CAMERA;

public class PackControl extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private static final int REQUEST_CAMERA = 1;
    private ZXingScannerView scannerView;

    ImageView btnScan;
    ListView lvPack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pack);

        bottomMenuControl();
        AnhXa();
        getShippingInfosByDriver();

        scannerView = new ZXingScannerView(this);


        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(scannerView);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkPermission()) {
                        Toast.makeText(PackControl.this, "Permission already granted!", Toast.LENGTH_LONG).show();
                    } else {
                        requestPermission();
                    }
                }

            }
        });


    }


    public void getShippingInfosByDriver(){
        Call<ShippingInfo> shippingInfoCall = ApiClient.getShippingInfoService().getShippingInfosByDriver("Bearer " + MainActivity.token, 1, 20);
        shippingInfoCall.enqueue(new Callback<ShippingInfo>() {
            @Override
            public void onResponse(Call<ShippingInfo> call, Response<ShippingInfo> response) {
                ShippingInfo shippingInfo = response.body();
            }

            @Override
            public void onFailure(Call<ShippingInfo> call, Throwable t) {

            }
        });
    }

    private boolean checkPermission() {
        return (ContextCompat.checkSelfPermission(PackControl.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, REQUEST_CAMERA);
    }


    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CAMERA:
                if (grantResults.length > 0) {
                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (cameraAccepted) {
                        Toast.makeText(PackControl.this, "Permission Granted, Now you can access camera", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(PackControl.this, "Permission Denied, You cannot access and camera", Toast.LENGTH_LONG).show();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(CAMERA)) {
                                showMessageOKCancel("You need to allow access to both the permissions",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{CAMERA},
                                                            REQUEST_CAMERA);
                                                }
                                            }
                                        });
                                return;
                            }
                        }
                    }
                }
                break;
        }
    }

    public void onResume() {
        super.onResume();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkPermission()) {
                if (scannerView == null) {
                    scannerView = new ZXingScannerView(this);
                    setContentView(scannerView);
                }
                scannerView.setResultHandler(this);
                scannerView.startCamera();

            }
        } else {
            requestPermission();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        scannerView.stopCamera();
    }


    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(PackControl.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }


    public void bottomMenuControl() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.packing);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.tracking:
                        startActivity(new Intent(getApplicationContext(), TrackingSupply.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.packing:
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(), GetUserInfo.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }


    @Override
    public void handleResult(Result result) {
        Call<DefaultResponse<ShippingInfo>> defaultResponseShippingInfoCall =
                ApiClient.getShippingInfoService().editShippingInfoByToken("Bearer " + MainActivity.token ,result.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        defaultResponseShippingInfoCall.enqueue(new Callback<DefaultResponse<ShippingInfo>>() {
            @Override
            public void onResponse(Call<DefaultResponse<ShippingInfo>> call, Response<DefaultResponse<ShippingInfo>> response) {
                DefaultResponse<ShippingInfo> defaultResponse = response.body();
                final String myResult = result.getText();
                Log.d("QRCodeScanner", result.getText());
                Log.d("QRCodeScanner", result.getBarcodeFormat().toString());


                builder.setTitle("THÔNG BÁO");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        scannerView.resumeCameraPreview(PackControl.this);
//                        scannerView.stopCamera();
                    }
                });

                if(response.isSuccessful()) {
                    String thongbao = defaultResponse.getMessage();
                    builder.setMessage("" + thongbao);
                    AlertDialog alert1 = builder.create();
                    alert1.show();
                }else{
                    ErrorResponse message = new Gson().fromJson(response.errorBody().charStream(), ErrorResponse.class);
                    String thongbaofail = message.getMessage();
                    builder.setMessage("" + thongbaofail);
                    AlertDialog alert1 = builder.create();
                    alert1.show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse<ShippingInfo>> call, Throwable t) {

            }
        });
    }

    private void AnhXa() {
        lvPack = (ListView) findViewById(R.id.listviewPack);
        btnScan = (ImageView) findViewById(R.id.qrScan);
    }
}