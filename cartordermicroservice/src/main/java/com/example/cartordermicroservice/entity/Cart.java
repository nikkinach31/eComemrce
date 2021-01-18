package com.example.cartordermicroservice.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int cartId;

    private int userId;
    private double expenses;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cart_id")
    private List<CartItems>  items;

    public double getExpenses()
    {
        return expenses;
    }

    public void setExpenses(double expenses)
    {
        this.expenses = expenses;
    }

    public List<CartItems> getItems()
    {
        if (this.items == null)
        {
            this.items = new ArrayList<>();
        }
        return items;
    }

    public void setItems(List<CartItems> items)
    {
        this.items = items;
    }

    public int getCartId()
    {
        return cartId;
    }

    public void setCartId(int cartId)
    {
        this.cartId = cartId;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }
}