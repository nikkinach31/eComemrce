package com.example.cartordermicroservice.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_order")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int orderId;

    private int userId;
    private double expenses;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "order_id")
    private List<OrderDetails> orderDetails;

    public List<OrderDetails> getOrderDetails()
    {
        if(this.orderDetails == null)
        {
            this.orderDetails = new ArrayList<>();
        }
        return orderDetails ;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails)
    {
        this.orderDetails = orderDetails;
    }

    public int getOrderId()
    {
        return orderId;
    }

    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public double getExpenses()
    {
        return expenses;
    }

    public void setExpenses(double expenses)
    {
        this.expenses = expenses;
    }
}