package com.example.container_rounduse_marketplace_android.controller;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.container_rounduse_marketplace_android.R;
import com.example.container_rounduse_marketplace_android.models.Pack;
import com.example.container_rounduse_marketplace_android.ui.PackControl;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Pack> packList;

    public ListAdapter(Context context, int layout, List<Pack> packList) {
        this.context = context;
        this.layout = layout;
        this.packList = packList;
    }


    @Override
    public int getCount() {
        return packList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    private class ViewHolder {
        ImageView imgHinh;
        TextView packingStation, portOfLoading, packingTime, cutOffTime, txtStatus;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder = new ViewHolder();
            //ánh xạ view
            holder.packingStation = (TextView) view.findViewById(R.id.textviewPackingStation);
            holder.txtStatus = (TextView) view.findViewById(R.id.textviewStatus);
            holder.portOfLoading = (TextView) view.findViewById(R.id.textviewPortOfLoading);
            holder.packingTime = (TextView) view.findViewById(R.id.textviewPackingTime);
            holder.cutOffTime = (TextView) view.findViewById(R.id.textviewCutOffTime);
            holder.imgHinh = (ImageView) view.findViewById(R.id.imageviewHinh);
            view.setTag(holder);

            if (PackControl.status.equals("DELIVERED")) {
                holder.txtStatus.setTextColor(Color.parseColor("#128e17"));
            }
            if (PackControl.status.equals("PENDING")) {
                holder.txtStatus.setTextColor(Color.parseColor("#673AB7"));
            }
            if (PackControl.status.equals("INFO_RECEIVED")) {
                holder.txtStatus.setTextColor(Color.parseColor("#2196F3"));
            }
            if (PackControl.status.equals("SHIPPING")) {
                holder.txtStatus.setTextColor(Color.parseColor("#FB6C00"));
            }

        } else {
            holder = (ViewHolder) view.getTag();
        }


        //gán giá trị
        Pack pack = packList.get(i);
        holder.packingStation.setText(pack.getPackingStation());
        holder.portOfLoading.setText(pack.getPortOfLoading());
        holder.packingTime.setText(pack.getPackingTime());
        holder.cutOffTime.setText(pack.getCutOffTime());
        holder.txtStatus.setText(pack.getStatus());
        holder.imgHinh.setImageResource(pack.getHinh());

        return view;


    }


}
