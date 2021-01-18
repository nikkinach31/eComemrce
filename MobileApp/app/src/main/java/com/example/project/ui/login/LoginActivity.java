package com.example.project.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.example.project.R;
import com.example.project.ui.login.model.User;
import com.example.project.ui.login.network.LoginAPI;
import com.example.project.ui.login.networkmanager.LoginRetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_login);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        findViewById(R.id.tv_sign_up).setOnClickListener(View -> {
            Intent intent = new Intent(this,RegisterActivity.class);
            startActivity(intent);
        });


        findViewById(R.id.iv_google).setOnClickListener(View -> {
            Retrofit retrofit = LoginRetrofitBuilder.getInstance();
            LoginAPI loginAPI = retrofit.create(LoginAPI.class);
            Call<User> usercall = loginAPI.getUser();

            usercall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {

                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });
        });


//        SharedPreferences sharedPreferences = getSharedPreferences("com.example.project", Context.MODE_PRIVATE);
//        Boolean loggedInUser = sharedPreferences.getBoolean("LoggedIn", false);
        //******************************************************************************
        // --> API call to enter/save user details
        //******************************************************************************

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}