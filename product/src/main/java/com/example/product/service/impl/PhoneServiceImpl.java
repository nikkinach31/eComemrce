package com.example.product.service.impl;

import com.example.product.entity.MerchantInventory;
import com.example.product.entity.MerchantStock;
import com.example.product.entity.Phone;
import com.example.product.entity.PhoneHomepage;
import com.example.product.repository.ProductRepository;
import com.example.product.service.PhoneService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    ProductRepository productRepository;

    Logger logger = LoggerFactory.getLogger("log1");
    List<Integer> merchantStocksProductIds = new ArrayList<Integer>();

    @Override
    public Phone findById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Phone getByProductId(int id)
    {
        return productRepository.findById(id).get();
    }

    @Override
    @KafkaListener(topics = "product", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "kafkaListenerContainerFactory")
    public void insert(String merchantInventoryString) throws JsonProcessingException {
        logger.info("insert complete!");
        Phone phone = new Phone();
        ObjectMapper mapper = new ObjectMapper();
        MerchantInventory merchantInventory = mapper.readValue(merchantInventoryString, MerchantInventory.class);
        phone.setProductId(merchantInventory.getProductId());
        phone.setName(merchantInventory.getName());
        phone.setBrand(merchantInventory.getBrand());
        phone.setModelName(merchantInventory.getModelName());
        phone.setCamera(merchantInventory.getCamera());
        phone.setColor(merchantInventory.getColor());
        phone.setMemory(merchantInventory.getMemory());
        phone.setPrice(merchantInventory.getPrice());
        phone.setProductImage(merchantInventory.getProductImage());
        productRepository.save(phone);
    }

    @Override
    @KafkaListener(topics = "stock", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "kafkaListenerContainerFactory")
    public List<PhoneHomepage> findProductByItemsSold(String merchantStocksString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        merchantStocksProductIds.add(mapper.readValue(merchantStocksString, MerchantStock.class).getProductId());
        List<PhoneHomepage> productHomepage = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Phone phone = findById(merchantStocksProductIds.get(i));
            PhoneHomepage hPhone = new PhoneHomepage();
            hPhone.setProductId(phone.getProductId());
            hPhone.setName(phone.getName());
            hPhone.setPrice(phone.getPrice());
            hPhone.setProductImage(phone.getProductImage());
            productHomepage.add(hPhone);
        }
        return productHomepage;
    }
}
