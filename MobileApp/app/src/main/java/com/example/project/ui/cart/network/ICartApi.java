package com.example.project.ui.cart.network;

import com.example.project.ui.cart.model.Cart;
import com.example.project.ui.cart.model.CartTotal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ICartApi {
    @GET("http://172.16.20.22:8081/cart/{userId}")
    Call<List<Cart>> getCart(@Path("userId") int userId);

    @GET("http://172.16.20.22:8081/cart/expenses/{userId}")
    Call<CartTotal> getCartTotal(@Path("userId") int userId);
}
