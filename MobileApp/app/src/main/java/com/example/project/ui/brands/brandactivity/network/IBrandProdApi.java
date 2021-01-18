package com.example.project.ui.brands.brandactivity.network;

import com.example.project.ui.brands.brandactivity.model.BrandProducts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IBrandProdApi {
    @GET("posts")
    Call<List<BrandProducts>> getBrandProducts();
}
