package com.example.product.service;

import com.example.product.entity.MerchantInventory;
import com.example.product.entity.Phone;
import com.example.product.entity.PhoneHomepage;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface PhoneService {
    Phone findById(int id);
    Phone getByProductId(int id);
    void insert(String merchantInventory) throws JsonProcessingException;
    List<PhoneHomepage> findProductByItemsSold() throws JsonProcessingException;
}
