package com.example.project.ui.cart.model;

import com.google.gson.annotations.SerializedName;

public class Cart{

	@SerializedName("prodImageUrl")
	private String prodImageUrl;

	@SerializedName("productName")
	private String productName;

	@SerializedName("productPrice")
	private double productPrice;

	public String getProdImageUrl(){
		return prodImageUrl;
	}

	public String getProductName(){
		return productName;
	}

	public double getProductPrice(){
		return productPrice;
	}
}