package com.example.cartordermicroservice.service;


import com.example.cartordermicroservice.entity.Cart;
import com.example.cartordermicroservice.entity.CartItems;

import java.util.List;

public interface CartService
{
    Cart getCart(int userId);

    void addToCartItems(CartItems cartItems);
}
