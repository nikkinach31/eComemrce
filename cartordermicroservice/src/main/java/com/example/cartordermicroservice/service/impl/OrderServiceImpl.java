package com.example.cartordermicroservice.service.impl;

import com.example.cartordermicroservice.repository.OrderRepository;
import com.example.cartordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    OrderRepository orderRepository;
}
