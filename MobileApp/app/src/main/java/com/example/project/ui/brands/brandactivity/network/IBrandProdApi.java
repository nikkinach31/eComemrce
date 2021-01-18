package com.example.project.ui.brands.brandactivity.network;

import com.example.project.ui.brands.brandactivity.model.BrandProducts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IBrandProdApi {
    @GET("/brand/{brand}")
    Call<List<BrandProducts>> getBrandProducts(@Path("brand") String brand);
}
