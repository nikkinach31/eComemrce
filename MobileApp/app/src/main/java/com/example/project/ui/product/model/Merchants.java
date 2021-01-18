package com.example.project.ui.product.model;

import com.google.gson.annotations.SerializedName;

public class Merchants{

	@SerializedName("merchantId")
	private int merchantId;

	@SerializedName("merchantPrice")
	private double merchantPrice;

	public int getMerchantId(){
		return merchantId;
	}

	public double getMerchantPrice(){
		return merchantPrice;
	}
}