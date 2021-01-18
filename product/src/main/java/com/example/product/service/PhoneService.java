package com.example.product.service;

import com.example.product.entity.Phone;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface PhoneService {
    Phone findById(int id);
    void insert(String merchantInventory) throws JsonProcessingException;
    List<Phone> findProductByItemsSold() throws JsonProcessingException;
    List<Phone> findProductByBrand(String brand);
    void updateRating(int id, float rating);
}
