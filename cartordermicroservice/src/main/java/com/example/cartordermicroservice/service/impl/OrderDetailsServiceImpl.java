package com.example.cartordermicroservice.service.impl;

import com.example.cartordermicroservice.repository.OrderDetailsRepository;
import com.example.cartordermicroservice.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService
{
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
}
