package com.example.ecommerce.services.impl;

import com.example.ecommerce.model.MerchantStock;
import com.example.ecommerce.repository.MerchantInventoryRepository;
import com.example.ecommerce.repository.MerchantStockRepository;
import com.example.ecommerce.services.MerchantStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantStockServiceImpl implements MerchantStockService {
    @Autowired
    MerchantStockRepository merchantStockRepository;

    @Autowired
    MerchantInventoryRepository merchantInventoryRepository;

    @Override
    public MerchantStock save(MerchantStock merchantStock) {
        return merchantStockRepository.save(merchantStock);
    }

    @Override
    public void deleteById(int id) {
        merchantStockRepository.deleteById(id);
    }

    @Override
    public MerchantStock findById(int id) {
        return merchantStockRepository.findById(id).get();
    }

    @Override
    public void updateStock(int inventoryId, int stock) {
        int newStock = findById(inventoryId).getStock() + stock;
        findById(inventoryId).setStock(newStock);
        merchantStockRepository.save(findById(inventoryId));
    }

    @Override
    public void updateItemsSold(int inventoryId, int itemsSold) {
        int newItemsSold = findById(inventoryId).getItemsSold() + itemsSold;
        int newStock = findById(inventoryId).getStock() - itemsSold;
        findById(inventoryId).setItemsSold(newItemsSold);
        findById(inventoryId).setStock(newStock);
        merchantStockRepository.save(findById(inventoryId));
    }

    @Override
    public List<MerchantStock> findByOrderByItemsSoldDesc() {
        return merchantStockRepository.findByOrderByItemsSoldDesc();
    }

    @Override
    public int findStockById(int id) {
        return findById(id).getStock();
    }

    @Override
    public int findStockByMerchantIdAndProductId(int merchantId, int productId) {
        int inventoryId = merchantInventoryRepository.findByMerchantIdAndProductId(merchantId, productId).getId();
        return findById(inventoryId).getStock();
    }
}
