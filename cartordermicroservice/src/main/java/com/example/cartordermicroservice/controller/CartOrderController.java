package com.example.cartordermicroservice.controller;

import com.example.cartordermicroservice.entity.Cart;
import com.example.cartordermicroservice.entity.CartItems;
import com.example.cartordermicroservice.service.CartItemsService;
import com.example.cartordermicroservice.service.CartService;
import com.example.cartordermicroservice.service.OrderDetailsService;
import com.example.cartordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cart") //enter value based on API
public class CartOrderController
{
    @Autowired
    CartService cartService;

    @Autowired
    CartItemsService cartItemsService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailsService orderDetailsService;

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable("userId") int userId)
    {
        return cartService.getCart(userId);
    }

    @PostMapping(value = "/addToCart")
    public void addToCartItems(@RequestBody CartItems cartItems)
    {
        cartService.addToCartItems(cartItems);
    }
}
