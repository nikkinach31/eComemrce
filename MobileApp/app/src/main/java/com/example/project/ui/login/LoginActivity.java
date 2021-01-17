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