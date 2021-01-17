package com.example.ecommerce.services;

import com.example.ecommerce.model.MerchantStock;

import java.util.List;

public interface MerchantStockService {
    MerchantStock save (MerchantStock merchantStock);
    void deleteById(int id);
    MerchantStock findById(int id);
    void updateStock(int inventoryId, int stock);
    List<MerchantStock> findByOrderByItemsSoldDesc();
    int findStockById(int id);
    //updateItemsSold
}
