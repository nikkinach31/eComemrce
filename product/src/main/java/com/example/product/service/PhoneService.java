package com.example.product.service;

import com.example.product.entity.MerchantInventory;
import com.example.product.entity.Phone;

public interface PhoneService {
    Phone getByProductId(int id);
    void insert(MerchantInventory merchantInventory);
}
