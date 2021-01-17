package com.example.project.ui.home.network;

import com.example.project.ui.home.model.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IProdApi {
    @GET("posts")
    Call<List<Products>> getProducts();
}

