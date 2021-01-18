package com.example.ecommerce.services;

import com.example.ecommerce.model.MerchantStock;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface MerchantStockService {
    MerchantStock save(MerchantStock merchantStock);
    void deleteById(int id);
    MerchantStock findById(int id);
    void updateStock(int inventoryId, int stock);
    List<MerchantStock> findByOrderByItemsSoldDesc() throws JsonProcessingException;
    int findStockById(int id);
    int findStockByMerchantIdAndProductId(int merchantId, int productId);
    void updateItemsSold(int inventoryId, int itemsSold);
}
