package com.example.sruthi.testretrofit.HomeActivity.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.crashlytics.android.Crashlytics;
import com.example.sruthi.testretrofit.HomeActivity.Model.UserListDataModel;
import com.example.sruthi.testretrofit.HomeActivity.WebAPI.UserListAPI;
import com.example.sruthi.testretrofit.R;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context con;
    AtmHolder h1;
    private List<UserListDataModel> listUsers;


    public ListAdapter(List<UserListDataModel> listUsers, Context con) {
        this.listUsers = listUsers;
        Fabric.with(con, new Crashlytics());
        this.con = con;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        RecyclerView.ViewHolder viewHolder = null;

        if (position == 0) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item_list, viewGroup, false);
            viewHolder = new AtmHolder(v);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {


        if (holder instanceof AtmHolder) {
            h1 = (AtmHolder) holder;

           h1.tv_name.setText(listUsers.get(position).getName());
            Glide.with(con)
                    .load(listUsers.get(position).getImage())
                    .error(R.drawable.ic_launcher_background)
                    .override(100, 100)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(h1.img_icon);

            h1.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                       crash();

                }
            });


        }
    }

    private void crash() {
        // TODO: Use the current user's information
        // You can call any combination of these three methods
        Crashlytics.setUserIdentifier("12345");
        Crashlytics.setUserEmail("shruthigvr@gmail.com");
        Crashlytics.setUserName("Test User");
        throw new RuntimeException("This is a crash");


    }



    @Override
    public int getItemCount() {
        return (null != listUsers ? listUsers.size() : 0);
    }



    public static class AtmHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        ImageView img_icon;

        AtmHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.textName);
            img_icon = itemView.findViewById(R.id.image_icon);

        }

    }
}
