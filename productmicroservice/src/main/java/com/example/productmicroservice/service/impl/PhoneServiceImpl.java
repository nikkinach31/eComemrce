package com.example.productmicroservice.service.impl;

import com.example.productmicroservice.entity.Phone;
import com.example.productmicroservice.repository.ProductRepository;
import com.example.productmicroservice.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService
{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Phone getByProductId(int id)
    {
        return productRepository.findById(id).get();
    }

}
