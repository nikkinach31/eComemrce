package com.example.ecommerce.services.impl;

import com.example.ecommerce.model.MerchantInventory;
import com.example.ecommerce.model.MerchantStock;
import com.example.ecommerce.repository.MerchantInventoryRepository;
import com.example.ecommerce.repository.MerchantStockRepository;
import com.example.ecommerce.services.MerchantInventoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantInventoryServiceImpl implements MerchantInventoryService {
    @Autowired
    MerchantInventoryRepository merchantInventoryRepository;

    @Autowired
    MerchantStockRepository merchantStockRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void save(MerchantInventory merchantInventory) throws JsonProcessingException {
        merchantInventoryRepository.save(merchantInventory);
        merchantInventory.setProductId();
//        String merchantInventoryString = merchantInventory.toString();
        ObjectMapper mapper = new ObjectMapper();
        kafkaTemplate.send("product", mapper.writeValueAsString(merchantInventory));
        merchantStockRepository.save(new MerchantStock(merchantInventory.getId(), merchantInventory.getProductId(), merchantInventory.getQuantity()));
    }

    @Override
    public MerchantInventory findById(int id) {
        return merchantInventoryRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
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
