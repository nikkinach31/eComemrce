package com.example.project.ui.login.network;

import com.example.project.ui.login.model.User;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LoginAPI {
    @GET("")
    Call<User> getUser();

}

