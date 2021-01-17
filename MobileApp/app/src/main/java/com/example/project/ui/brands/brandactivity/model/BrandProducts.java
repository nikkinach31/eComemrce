package com.example.project.ui.brands.brandactivity.model;

import com.google.gson.annotations.SerializedName;

public class BrandProducts {

    @SerializedName("image")
	private String image;

	@SerializedName("modelName")
	private String modelName;

	@SerializedName("memory")
	private String memory;

	@SerializedName("productId")
	private int productId;

	@SerializedName("color")
	private String color;

	@SerializedName("camera")
	private String camera;

	@SerializedName("brand")
	private String brand;

	@SerializedName("price")
	private double price;

	@SerializedName("rating")
	private double rating;

	public String getImage() {
		return image;
	}

	public String getModelName(){
		return modelName;
	}

	public String getMemory(){
		return memory;
	}

	public int getProductId(){
		return productId;
	}

	public String getColor(){
		return color;
	}

	public String getCamera(){
		return camera;
	}

	public String getBrand(){
		return brand;
	}

	public double getPrice() {
		return price;
	}

	public double getRating() {
		return rating;
	}
}
