package com.example.cartordermicroservice.service;

import com.example.cartordermicroservice.entity.Cart;
import com.example.cartordermicroservice.entity.CartItems;
import com.example.cartordermicroservice.entity.Order;
import com.example.cartordermicroservice.entity.OrderDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CheckoutService
{
    Cart getCartById(int cartId);

    public void addToOrders(Order newOrder);

    int findStock(int mid, int pid);
}
