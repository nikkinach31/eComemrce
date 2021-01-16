package com.example.cartordermicroservice.service.impl;

import com.example.cartordermicroservice.entity.Cart;
import com.example.cartordermicroservice.entity.CartItems;
import com.example.cartordermicroservice.entity.Order;
import com.example.cartordermicroservice.entity.OrderDetails;
import com.example.cartordermicroservice.repository.CartRepository;
import com.example.cartordermicroservice.repository.OrderRepository;
import com.example.cartordermicroservice.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutServiceImpl implements CheckoutService
{
    @Autowired
    CartRepository cartRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Cart getCartById(int cartId)
    {
        return cartRepository.findById(cartId).get();
    }

    @Override
    public void addToOrders(Order newOrder)
    {
        orderRepository.save(newOrder);
    }
}
