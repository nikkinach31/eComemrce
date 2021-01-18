package com.example.project.ui.home.model;

import com.google.gson.annotations.SerializedName;

public class Products{

	@SerializedName("modelName")
	private String modelName;

	@SerializedName("memory")
	private String memory;

	@SerializedName("productImage")
	private String productImage;

	@SerializedName("productId")
	private int productId;

	@SerializedName("color")
	private String color;

	@SerializedName("price")
	private double price;

	@SerializedName("name")
	private String name;

	@SerializedName("camera")
	private String camera;

	@SerializedName("brand")
	private String brand;

	public String getModelName(){
		return modelName;
	}

	public String getMemory(){
		return memory;
	}

	public String getProductImage(){
		return productImage;
	}

	public int getProductId(){
		return productId;
	}

	public String getColor(){
		return color;
	}

	public double getPrice(){
		return price;
	}

	public String getName(){
		return name;
	}

	public String getCamera(){
		return camera;
	}

	public String getBrand(){
		return brand;
	}
}