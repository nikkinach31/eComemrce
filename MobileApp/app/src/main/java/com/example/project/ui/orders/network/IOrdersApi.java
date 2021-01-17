package com.example.project.ui.orders.network;

import com.example.project.ui.orders.model.Orders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IOrdersApi {
    @GET("posts")
    Call<List<Orders>> getOrders();
}
