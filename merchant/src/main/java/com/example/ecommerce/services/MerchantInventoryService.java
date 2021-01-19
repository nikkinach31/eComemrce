package com.example.ecommerce.services;

import com.example.ecommerce.model.MerchantIdAndPrice;
import com.example.ecommerce.model.MerchantInventory;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface MerchantInventoryService {
    void save(MerchantInventory merchantInventory) throws JsonProcessingException;
    MerchantInventory findById(int id);
    void deleteById(int id) throws JsonProcessingException;
    List<MerchantInventory> findByMerchantId(int merchantId);
    void updatePrice(int id, double price);
    MerchantInventory findByMerchantIdAndProductId(int merchantId, int productId);
    List<MerchantInventory> findByBrand(String brand);
    List<MerchantIdAndPrice> findByProductId(int productId);
}
