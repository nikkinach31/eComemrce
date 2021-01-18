package com.example.cartordermicroservice.service.impl;

import com.example.cartordermicroservice.entity.Cart;
import com.example.cartordermicroservice.entity.CartItems;
import com.example.cartordermicroservice.repository.CartItemsRepository;
import com.example.cartordermicroservice.repository.CartRepository;
import com.example.cartordermicroservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService
{
    @Autowired
    CartRepository  cartRepository;

    @Autowired
    CartItemsRepository cartItemsRepository;

    @Override
    public List<CartItems> getCartDet(int userId)
    {
        Cart myCart = cartRepository.findById(userId).get();
        return myCart.getItems();
    }

    @Override
    @Transactional(readOnly = false)
    public void addToCartItems(CartItems cartItems)
    {
        Optional<Cart> cart = cartRepository.findById(cartItems.getUserId());
//        List<CartItems> existingItems = new ArrayList<>();
//
        double expenses=0;
//
//        for(CartItems item : existingItems)
//        {
//            expenses += (item.getPrice()*item.getQuantity());
//        }

        expenses += (cartItems.getPrice()*cartItems.getQuantity());
        Cart mCart1 ;
         if (cart.isPresent())
         {
             mCart1 = cart.get();

             List<CartItems> existingItems = mCart1.getItems();

             for(CartItems currItem : existingItems)
             {
                 if(cartItems.getProductId()==currItem.getProductId())
                 {
                     int itemId = currItem.getItemId();
                     System.out.println(itemId);
                     currItem.setQuantity(cartItems.getQuantity());
                     mCart1.setExpenses(expenses );
                     cartRepository.save(mCart1);
                     return;
                 }
             }
             mCart1.getItems().add(cartItems);
             mCart1.setExpenses(mCart1.getExpenses()+expenses);
             cartRepository.save(mCart1);
         }
         else
         {
             Cart newCart = new Cart();
             newCart.setUserId(cartItems.getUserId());
             newCart.getItems().add(cartItems);
             newCart.setExpenses(expenses);
             cartRepository.save(newCart);
         }
    }

    @Override
    public Cart getCart(int userId)
    {
        return cartRepository.findById(userId).get();
    }
}