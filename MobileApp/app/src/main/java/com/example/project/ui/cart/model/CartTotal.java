package com.example.project.ui.cart.model;

import com.google.gson.annotations.SerializedName;

public class CartTotal {

    @SerializedName("totalAmount")
    private double totalAmount;

    public double getTotalAmount(){
        return totalAmount;
    }
}
