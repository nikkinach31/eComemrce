package com.example.productmicroservice.service;

import com.example.ecommerce.model.MerchantInventory;
import com.example.productmicroservice.entity.Phone;

public interface PhoneService
{   //join tables to get all the information for product detail page
    Phone getByProductId(int id);
    void insert(MerchantInventory merchantInventory);
}
