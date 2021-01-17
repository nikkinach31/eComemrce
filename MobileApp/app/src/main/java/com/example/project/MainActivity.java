package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.project.ui.cart.CartActivity;
import com.example.project.ui.login.LoginActivity;
import com.example.project.ui.profilelogout.ProfileActivity;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();


        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration
                .Builder(R.id.nav_home, R.id.nav_brands, R.id.nav_orders)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //search bar functionality
        SearchView etSearch = findViewById(R.id.et_search_bar);
        etSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "Query Text = " + query, Toast.LENGTH_SHORT).show();

//                    //******************************************************************************
//                    // --> API call to search products
//                    //******************************************************************************
//
//                    //performSearch();  // --> calling search method
//                    //new SearchForEquipmentTask(false, viewHolder.mTextSearch.getQuery().toString()).execute();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //search(newText);
//                Toast.makeText(MainActivity.this, "New Query Text = " + newText, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SearchView etSearch = findViewById(R.id.et_search_bar);
        etSearch.clearFocus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cart:
                startActivity(new Intent(this, CartActivity.class));
                break;

            case R.id.action_login:
                checkIfLogin();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void checkIfLogin() {
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.project", Context.MODE_PRIVATE);
        Boolean loggedInUser = sharedPreferences.getBoolean("LoggedIn", false);

        if (loggedInUser.equals(false)) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        } else {
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }
}