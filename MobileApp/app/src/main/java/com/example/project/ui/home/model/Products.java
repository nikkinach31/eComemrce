package com.example.project.ui.home.model;

import com.google.gson.annotations.SerializedName;

public class Products{

//	private String name;
//	private String imageUrl;
//	private double price;
//
//	public Products(String name, String imageUrl, double price) {
//		this.name = name;
//		this.imageUrl = imageUrl;
//		this.price = price;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getImageUrl() {
//		return imageUrl;
//	}
//
//	public void setImageUrl(String imageUrl) {
//		this.imageUrl = imageUrl;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//	---------------------------------------------------------------------------------------
//	---------------------------------------------------------------------------------------

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