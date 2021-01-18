package com.example.cartordermicroservice.service.impl;

import com.example.cartordermicroservice.entity.Cart;
import com.example.cartordermicroservice.entity.CartItems;
import com.example.cartordermicroservice.repository.CartItemsRepository;
import com.example.cartordermicroservice.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemsServiceImpl implements CartItemsService
{
    @Autowired
    CartItemsRepository cartItemsRepository;

//    @Override
//    public void addToCartItems(CartItems cartItems)
//    {
//        cartItemsRepository.save(cartItems);
//    }
}
