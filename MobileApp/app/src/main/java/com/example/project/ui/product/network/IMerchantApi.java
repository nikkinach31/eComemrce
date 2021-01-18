package com.example.project.ui.product.network;

import com.example.project.ui.product.model.Merchants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IMerchantApi {
    @GET("http://172.16.20.22:9000/merchant/inventory/merchants/{productId}")
    Call<List<Merchants>> getMerchants(@Path("productId") int productId);
}
