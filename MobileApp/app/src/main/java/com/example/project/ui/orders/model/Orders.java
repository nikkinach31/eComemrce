package com.example.project.ui.orders.model;

import java.util.Date;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Orders{

	private int orderAmount;
	private Date orderDate;
	private List<OrderItems> orderItems;

	public Orders(int orderAmount, Date orderDate, List<OrderItems> orderItems) {
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
		this.orderItems = orderItems;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	//	@SerializedName("orderAmount")
//	private int orderAmount;
//
//	@SerializedName("orderDate")
//	private String orderDate;
//
//	@SerializedName("orderItems")
//	private List<OrderItems> orderItems;
//
//	public int getOrderAmount(){
//		return orderAmount;
//	}
//
//	public String getOrderDate(){
//		return orderDate;
//	}
//
//	public List<OrderItems> getOrderItems(){
//		return orderItems;
//	}
}