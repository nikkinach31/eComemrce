package com.example.ecommerce.services;

import com.example.ecommerce.model.MerchantInventory;

import java.util.List;

public interface MerchantInventoryService {
    void save(MerchantInventory merchantInventory);
    MerchantInventory findById(int id);
    void deleteById(int id);
    List<MerchantInventory> findByMerchantId(int merchantId);
    void updatePrice(int id, double price);
}
