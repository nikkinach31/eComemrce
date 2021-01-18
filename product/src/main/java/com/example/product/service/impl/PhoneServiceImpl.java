package com.example.product.service.impl;

import com.example.product.entity.MerchantInventory;
import com.example.product.entity.MerchantStock;
import com.example.product.entity.Phone;
import com.example.product.repository.ProductRepository;
import com.example.product.service.PhoneService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Override
    public Phone findById(int id)
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
        phone.setId(merchantInventory.getId());
        phone.setProductId(merchantInventory.getProductId());
        phone.setName(merchantInventory.getName());
        phone.setBrand(merchantInventory.getBrand());
        phone.setCamera(merchantInventory.getCamera());
        phone.setColor(merchantInventory.getColor());
        phone.setMemory(merchantInventory.getMemory());
        phone.setPrice(merchantInventory.getPrice());
        phone.setProductImage(merchantInventory.getProductImage());
        phone.setRating(0.0f);
        productRepository.save(phone);

    }

    @Override
    public List<Phone> findProductByItemsSold() {
        List<Phone> productHomepage = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String sortAPI = "http://localhost:9000/merchant/stock/sort";
        ResponseEntity<MerchantStock[]> response = restTemplate.getForEntity(sortAPI, MerchantStock[].class);
        MerchantStock[] merchantStockLists = response.getBody();

        for (int i = 0; i < 20; i++) {
            Phone phone = findById(merchantStockLists[i].getInventoryId());
            productHomepage.add(phone);
        }
        return productHomepage;
    }

    @Override
    public List<Phone> findProductByBrand(String brand) {
//        List<Phone> brandHomepage = new ArrayList<>();
//        RestTemplate restTemplate = new RestTemplate();
//        String sortAPI = "http://localhost:9000/merchant/inventory/brand/" + brand;
//        ResponseEntity<MerchantInventory[]> response = restTemplate.getForEntity(sortAPI, MerchantInventory[].class);
//        for (MerchantInventory merchantInventory : response.getBody()) {
//            Phone phone = new Phone();
//            phone.setProductId(merchantInventory.getProductId());
//            phone.setName(merchantInventory.getName());
//            phone.setBrand(merchantInventory.getBrand());
//            phone.setCamera(merchantInventory.getCamera());
//            phone.setColor(merchantInventory.getColor());
//            phone.setMemory(merchantInventory.getMemory());
//            phone.setPrice(merchantInventory.getPrice());
//            phone.setProductImage(merchantInventory.getProductImage());
//            brandHomepage.add(phone);
//        }
//        return brandHomepage;
        return productRepository.findByBrand(brand);
    }

    @Override
    public void updateRating(int id, float rating) {
        findById(id).setRating(rating);
        productRepository.save(findById(id));
    }
}
