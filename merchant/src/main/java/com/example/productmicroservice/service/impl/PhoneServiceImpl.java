package com.example.productmicroservice.service.impl;

import com.example.ecommerce.model.MerchantInventory;
import com.example.productmicroservice.entity.Phone;
import com.example.productmicroservice.repository.ProductRepository;
import com.example.productmicroservice.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService
{
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
