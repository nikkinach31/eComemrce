package com.example.project.ui.login.network;

import com.example.project.ui.home.model.Products;
import com.example.project.ui.login.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LoginAPI {

    @GET("")
    Call<User> getUser();

}

