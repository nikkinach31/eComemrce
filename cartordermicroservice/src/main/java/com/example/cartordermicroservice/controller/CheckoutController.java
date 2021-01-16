package com.example.cartordermicroservice.controller;

import com.example.cartordermicroservice.entity.Cart;
import com.example.cartordermicroservice.entity.CartItems;
import com.example.cartordermicroservice.entity.Order;
import com.example.cartordermicroservice.entity.OrderDetails;
import com.example.cartordermicroservice.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/checkout") //endpoint
public class CheckoutController
{
    @Autowired
    CheckoutService checkoutService;


    //from Merchant Micro-service

    int findStock(int mid, int pid)
    {
        //get api call from Merchant Micro-service
       return 5000;
    }


    @PostMapping
    public int checkout(@RequestBody Cart cartId)
    {
        int cId = cartId.getCartId();
        Cart buyCart = checkoutService.getCartById(cId);
        if(buyCart.getUserId()==0)
        {
            return 0;
        }

        List<CartItems> buyCartItems = buyCart.getItems();

        for(CartItems cartItem : buyCartItems)
        {
            int itemQuantity = cartItem.getQuantity();
            int stock = findStock(cartItem.getMerchantId(), cartItem.getProductId());
            if(itemQuantity>stock)
            {
                return 2;
            }
        }

        Order newOrder = new Order();
        newOrder.setUserId(buyCart.getUserId());
        List<OrderDetails> newOrderDetails = new ArrayList<>();

        for(CartItems cartItem : buyCartItems)
        {
            OrderDetails orderDetail = new OrderDetails();
            orderDetail.setMerchantId(cartItem.getMerchantId());
            orderDetail.setPrice(cartItem.getPrice());
            orderDetail.setProductId(cartItem.getProductId());
            orderDetail.setProductName(cartItem.getProductName());
            orderDetail.setQuantity(cartItem.getQuantity());
            newOrderDetails.add(orderDetail);
        }
        newOrder.setExpenses(buyCart.getExpenses());
        newOrder.setOrderDetails(newOrderDetails);
        checkoutService.addToOrders(newOrder);
        return 1;
    }
}