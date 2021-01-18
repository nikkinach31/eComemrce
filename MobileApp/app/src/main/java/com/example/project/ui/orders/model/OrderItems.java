package com.example.project.ui.orders.model;

import com.google.gson.annotations.SerializedName;

public class OrderItems{

	private String image;
	private String modelName;
	private double price;
	private int quantity;
	private int rating;

	public OrderItems(String image, String modelName, double price, int quantity) {
		this.image = image;
		this.modelName = modelName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	//	@SerializedName("image")
//	private String image;
//
//	@SerializedName("modelName")
//	private String modelName;
//
//	@SerializedName("price")
//	private int price;
//
//	@SerializedName("quantity")
//	private int quantity;
//
//	@SerializedName("rating")
//	private int rating;
//
//	public String getImage(){
//		return image;
//	}
//
//	public String getModelName(){
//		return modelName;
//	}
//
//	public int getPrice(){
//		return price;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public int getRating(){
//		return rating;
//	}
//
//	public void setRating(int rating) {
//		this.rating = rating;
//	}
}