package com.example.project.ui.cart.network;

import com.example.project.ui.cart.model.Cart;
import com.example.project.ui.cart.model.CartTotal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ICartApi {
    @GET("posts")
    Call<List<Cart>> getCart();

    @GET("cartTotal")
    Call<CartTotal> getCartTotal();
}
