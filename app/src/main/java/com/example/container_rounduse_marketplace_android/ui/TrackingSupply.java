package com.example.container_rounduse_marketplace_android.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.container_rounduse_marketplace_android.R;
import com.example.container_rounduse_marketplace_android.models.Inbound;
import com.example.container_rounduse_marketplace_android.models.Port;
import com.example.container_rounduse_marketplace_android.models.ShippingInfo;
import com.example.container_rounduse_marketplace_android.until.ApiClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TrackingSupply extends AppCompatActivity {
    TextView pOfDeli, pOfLoad, returnStation, packingStation, timePickUp, timeFree, timePacking, timeCutOff, contNo, text1, text2, text3, text4;
    ImageView img1, img2, img3, img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracking_supply);
        bottomMenuControl();
        getShippingInfoActive();
        anhXa();
//        changeTracking();
    }

    public static String shipStatus;

    public void getShippingInfoActive() {
        Call<ShippingInfo> shippingInfoCall = ApiClient.getUserService().getShippingInfoAreActive("Bearer " + MainActivity.token);
        shippingInfoCall.enqueue(new Callback<ShippingInfo>() {
            @Override
            public void onResponse(Call<ShippingInfo> call, Response<ShippingInfo> response) {
                ShippingInfo shippingInfo = response.body();
                Long containerId = shippingInfo.getContainer().getId();
                String packStation = shippingInfo.getOutbound().getPackingStation();
                String packingTime = shippingInfo.getOutbound().getPackingTime();

                String portLoadingName = shippingInfo.getOutbound().getBooking().getPortOfLoading().getFullname();
                String cutOffTime = shippingInfo.getOutbound().getBooking().getCutOffTime();

                shipStatus = shippingInfo.getStatus();

                packingStation.setText(packStation);
                timePacking.setText("Thời gian đóng: " + packingTime);
                pOfLoad.setText(portLoadingName);
                timeCutOff.setText("Thời gian Cut-off: " + cutOffTime);

                //shipStatus
                changeTracking();

                Call<Inbound> inboundCall = ApiClient.getUserService().getInboundByContainer("Bearer " + MainActivity.token, containerId);
                inboundCall.enqueue(new Callback<Inbound>() {
                    @Override
                    public void onResponse(Call<Inbound> call, Response<Inbound> response) {
                        Inbound inbound = response.body();
                        String contNum = inbound.getBillOfLading().getNumber();
                        String portDeliName = inbound.getBillOfLading().getPortOfDelivery().getFullname();
                        String pickUpTime = inbound.getPickupTime();

                        String reStation = inbound.getReturnStation();
                        String freeTime = inbound.getBillOfLading().getFreeTime();

                        contNo.setText(" Lịch trình container: #" + contNum + " ");
                        pOfDeli.setText(portDeliName);
                        timePickUp.setText("Thời gian lấy: " + pickUpTime);
                        returnStation.setText(reStation);
                        timeFree.setText("Thời gian trả: " + freeTime);
                    }

                    @Override
                    public void onFailure(Call<Inbound> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Call<ShippingInfo> call, Throwable t) {

            }
        });
    }

    public void changeTracking() {
        if(!shipStatus.equals("EXCEPTION")) {
            if (shipStatus.equals("PENDING")) {
                img1.setImageResource(R.drawable.ic_baseline_done_24);
            }
            if (shipStatus.equals("INFO_RECEIVED")) {
                text1.setTextColor(Color.parseColor("#BBBBBB"));
                pOfDeli.setTextColor(Color.parseColor("#BBBBBB"));
                timePickUp.setTextColor(Color.parseColor("#BBBBBB"));
                img1.setImageResource(R.drawable.ic_baseline_done_24);

                img2.setImageResource(R.drawable.ic_baseline_done_24);
            }
            if (shipStatus.equals("SHIPPING")) {
                text1.setTextColor(Color.parseColor("#BBBBBB"));
                pOfDeli.setTextColor(Color.parseColor("#BBBBBB"));
                timePickUp.setTextColor(Color.parseColor("#BBBBBB"));
                img1.setImageResource(R.drawable.ic_baseline_done_24);

                text2.setTextColor(Color.parseColor("#BBBBBB"));
                returnStation.setTextColor(Color.parseColor("#BBBBBB"));
                timeFree.setTextColor(Color.parseColor("#BBBBBB"));
                img2.setImageResource(R.drawable.ic_baseline_done_24);

                img3.setImageResource(R.drawable.ic_baseline_done_24);
            }
            if (shipStatus.equals("DELIVERED")) {
                text1.setTextColor(Color.parseColor("#BBBBBB"));
                pOfDeli.setTextColor(Color.parseColor("#BBBBBB"));
                timePickUp.setTextColor(Color.parseColor("#BBBBBB"));
                img1.setImageResource(R.drawable.ic_baseline_done_24);

                text2.setTextColor(Color.parseColor("#BBBBBB"));
                returnStation.setTextColor(Color.parseColor("#BBBBBB"));
                timeFree.setTextColor(Color.parseColor("#BBBBBB"));
                img2.setImageResource(R.drawable.ic_baseline_done_24);

                text3.setTextColor(Color.parseColor("#BBBBBB"));
                packingStation.setTextColor(Color.parseColor("#BBBBBB"));
                timePacking.setTextColor(Color.parseColor("#BBBBBB"));
                img3.setImageResource(R.drawable.ic_baseline_done_24);

                img4.setImageResource(R.drawable.ic_baseline_done_24);
            }
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("THÔNG BÁO");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        }
    }

    public void anhXa() {
        pOfDeli = findViewById(R.id.textPortOfDelivery);
        pOfLoad = findViewById(R.id.textPortOfLoading);
        returnStation = findViewById(R.id.textReturnStation);
        packingStation = findViewById(R.id.textPackingStation);
        timePickUp = findViewById(R.id.textPickupTime);
        timeFree = findViewById(R.id.textFreeTime);
        timePacking = findViewById(R.id.textPackingTime);
        timeCutOff = findViewById(R.id.textCutOffTime);
        contNo = findViewById(R.id.textViewContainer);
        img1 = findViewById(R.id.imageView2);
        img2 = findViewById(R.id.imageView4);
        img3 = findViewById(R.id.imageView5);
        img4 = findViewById(R.id.imageView6);
        text1 = findViewById(R.id.textViewN);
        text2 = findViewById(R.id.textViewN2);
        text3 = findViewById(R.id.textViewN3);
        text4 = findViewById(R.id.textViewN4);

    }

    public void bottomMenuControl() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.tracking);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.tracking:
                        return true;
                    case R.id.packing:
                        startActivity(new Intent(getApplicationContext(), PackControl.class));
                        overridePendingTransition(0, 0);
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


}