package com.example.productmicroservice.service;

import com.example.productmicroservice.entity.Phone;

public interface PhoneService
{
    Phone getByProductId(int id);
}
