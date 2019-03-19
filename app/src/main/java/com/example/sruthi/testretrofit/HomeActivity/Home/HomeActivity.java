package com.example.sruthi.testretrofit.HomeActivity.Home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sruthi.testretrofit.HomeActivity.Adapter.ListAdapter;
import com.example.sruthi.testretrofit.HomeActivity.Model.UserListDataModel;
import com.example.sruthi.testretrofit.HomeActivity.Model.UserResultModel;
import com.example.sruthi.testretrofit.HomeActivity.Utils.RetrofitUtils;
import com.example.sruthi.testretrofit.HomeActivity.WebAPI.UserListAPI;
import com.example.sruthi.testretrofit.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
RecyclerView rvList;
LinearLayoutManager mLinearLayoutManager;
    ListAdapter adapter;
    List<UserResultModel> listResult;
    List<UserListDataModel> listUsers;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rvList = findViewById(R.id.rvList);
        pb = findViewById(R.id.progressBar);
        mLinearLayoutManager= new LinearLayoutManager(getApplicationContext());
        rvList.setLayoutManager(mLinearLayoutManager);
        list();
    }

    private void list() {
        pb.setVisibility(View.VISIBLE);
        UserListAPI awardsListAPI= RetrofitUtils.getRetrofitAdapter().create(UserListAPI.class);
        Call<UserResultModel> call = awardsListAPI.getValues("getalluserlist","23");
        call.enqueue(new Callback<UserResultModel>()
        {
            @Override
            public void onResponse(Call<UserResultModel> call, Response<UserResultModel> response)
            {
                if (response.isSuccessful())
                {
                    pb.setVisibility(View.GONE);
                    listUsers = response.body().getUserlist();
                    if (listUsers.size() > 0)
                    {
                        adapter = new ListAdapter(listUsers, HomeActivity.this);
                        rvList.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                    }
                    else
                    {
                        Toast.makeText(HomeActivity.this, "No data", Toast.LENGTH_SHORT).show();

                    }
                }
                else
                {
                    Toast.makeText(HomeActivity.this, "Failed to getting response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResultModel> call, Throwable t)
            {
                pb.setVisibility(View.VISIBLE);
                Log.d("AwardListError", "" + t);
            }
        });
    }


}

