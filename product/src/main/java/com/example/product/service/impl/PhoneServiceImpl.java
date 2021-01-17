package com.example.product.service.impl;

import com.example.product.entity.MerchantInventory;
import com.example.product.entity.Phone;
import com.example.product.repository.ProductRepository;
import com.example.product.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Phone getByProductId(int id)
    {
        return productRepository.findById(id).get();
    }

    @Override
    @KafkaListener(topics = "product", groupId = "${spring.kafka.consumer.group-id}")
    public void insert(MerchantInventory merchantInventory) {
        Phone phone = new Phone();
        phone.setProductId(merchantInventory.getProductId());
        phone.setName(merchantInventory.getName());
        phone.setBrand(merchantInventory.getBrand());
        phone.setModelName(merchantInventory.getModelName());
        phone.setCamera(merchantInventory.getCamera());
        phone.setColor(merchantInventory.getColor());
        phone.setMemory(merchantInventory.getMemory());
        //phone.setProductImage(merchantInventory.getProductImage());
        productRepository.save(phone);
    }

}
