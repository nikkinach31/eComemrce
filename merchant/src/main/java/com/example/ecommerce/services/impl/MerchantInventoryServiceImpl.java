package com.example.ecommerce.services.impl;

import com.example.ecommerce.model.MerchantInventory;
import com.example.ecommerce.model.MerchantStock;
import com.example.ecommerce.repository.MerchantInventoryRepository;
import com.example.ecommerce.repository.MerchantStockRepository;
import com.example.ecommerce.services.MerchantInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantInventoryServiceImpl implements MerchantInventoryService {
    @Autowired
    MerchantInventoryRepository merchantInventoryRepository;

    @Autowired
    KafkaTemplate<String, MerchantInventory> kafkaTemplate;

    @Autowired
    MerchantStockRepository merchantStockRepository;

    @Override
    public void save(MerchantInventory merchantInventory) {
//        merchantInventory.getProductId();
        merchantInventoryRepository.save(merchantInventory);
        merchantInventory.setProductId();
        kafkaTemplate.send("product", merchantInventory);
        merchantStockRepository.save(new MerchantStock(merchantInventory.getId(), merchantInventory.getQuantity()));
    }

    @Override
    public MerchantInventory findById(int id) {
        return merchantInventoryRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        kafkaTemplate.send("product", findById(id));
        merchantStockRepository.deleteById(id);
        merchantInventoryRepository.deleteById(id);
    }

    @Override
    public List<MerchantInventory> findByMerchantId(int merchant_id) {
        return merchantInventoryRepository.findByMerchantId(merchant_id);
    }

    @Override
    public void updatePrice(int id, double price) {
        findById(id).setPrice(price);
        merchantInventoryRepository.save(findById(id));
    }

    @Override
    public MerchantInventory findByMerchantIdAndProductId(int merchantId, int productId) {
        return merchantInventoryRepository.findByMerchantIdAndProductId(merchantId, productId);
    }
}
