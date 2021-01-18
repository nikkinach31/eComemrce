package com.example.project.ui.product.network;

import com.example.project.ui.product.model.Cart;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ICartApi {
    @POST("http://172.16.20.22:8081/cart/addToCart")
    Call<Cart> postCart(@Body Cart cart);
}
