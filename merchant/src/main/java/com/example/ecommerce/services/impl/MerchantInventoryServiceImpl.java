package com.example.ecommerce.services.impl;

import com.example.ecommerce.model.Merchant;
import com.example.ecommerce.model.MerchantIdAndPrice;
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

import java.util.ArrayList;
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
        for(MerchantInventory product : merchantInventoryRepository.findAll()) {
            if (product.getName().equals(merchantInventory.getName()) & product.getBrand().equals(merchantInventory.getBrand())
                    & product.getColor().equals(merchantInventory.getColor()) & product.getMemory().equals(merchantInventory.getMemory()) & product.getId() != merchantInventory.getId()) {
                merchantInventory.setProductId(product.getProductId());
                break;
            } else {
                merchantInventory.setProductId(merchantInventory.getId());
            }
        }
//        merchantInventory.setProductId();
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

    @Override
    public List<MerchantInventory> findByBrand(String brand) {
        return merchantInventoryRepository.findByBrand(brand);
    }

    @Override
    public List<MerchantIdAndPrice> findByProductId(int productId) {
        List<MerchantIdAndPrice> merchantIds = new ArrayList<>();
        List<MerchantInventory> merchantInventories = merchantInventoryRepository.findByProductId(productId);
        for (MerchantInventory merchantInventory : merchantInventories) {
            if (merchantStockRepository.findById(merchantInventory.getId()).get().getStock() != 0) {
                merchantIds.add(new MerchantIdAndPrice(merchantInventory.getMerchantId(), merchantInventory.getPrice()));
            }
        }
        return merchantIds;
    }
}
