package com.example.cartordermicroservice.controller;

import com.example.cartordermicroservice.entity.Cart;
import com.example.cartordermicroservice.entity.CartItems;
import com.example.cartordermicroservice.service.CartItemsService;
import com.example.cartordermicroservice.service.CartService;
import com.example.cartordermicroservice.service.OrderDetailsService;
import com.example.cartordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/{userId}")
    public List<CartItems> getCartDet(@PathVariable("userId") int userId)
    {
        List<CartItems> cartItems = cartService.getCartDet(userId);
        return cartItems;
    }


    public Cart getCart(int userId)
    {
        return cartService.getCart(userId);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping(value = "/addToCart")
    public void addToCartItems(@RequestBody CartItems cartItems)
    {
        cartService.addToCartItems(cartItems);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/expenses/{userId}")
    public double getExpenses(@PathVariable("userId") int userId)
    {
        double expenses = cartService.getCart(userId).getExpenses();
        return expenses;
    }
}
