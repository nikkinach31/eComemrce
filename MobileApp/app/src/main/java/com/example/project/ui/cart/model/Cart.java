package com.example.project.ui.cart.model;

import com.google.gson.annotations.SerializedName;

public class Cart{

    @SerializedName("itemId")
    private int itemId;

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("productId")
    private int productId;

    @SerializedName("merchantId")
    private int merchantId;

    @SerializedName("price")
    private double price;

    @SerializedName("imageURL")
    private String imageURL;

    @SerializedName("userId")
    private int userId;

    @SerializedName("productName")
    private String productName;

    public int getItemId(){
        return itemId;
    }

    public int getQuantity(){
        return quantity;
    }

    public int getProductId(){
        return productId;
    }

    public int getMerchantId(){
        return merchantId;
    }

    public double getPrice(){
        return price;
    }

    public String getImageURL(){
        return imageURL;
    }

    public int getUserId(){
        return userId;
    }

    public String getProductName(){
        return productName;
    }
}