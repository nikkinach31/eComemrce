package com.example.ecommerce.controller;

import com.example.ecommerce.model.MerchantIdAndPrice;
import com.example.ecommerce.model.MerchantInventory;
import com.example.ecommerce.services.MerchantInventoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/merchant/inventory")
public class MerchantInventoryController {

    @Autowired
    MerchantInventoryService merchantInventoryService;
//
//    @Autowired
//    KafkaTemplate<String, MerchantInventory> kafkaTemplate;

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping(value = "/{productId}")
    public MerchantInventory findById(@PathVariable("productId") int id) {
        return merchantInventoryService.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping(value = "/home/{merchantId}")
    public List<MerchantInventory> findByMerchantId(@PathVariable("merchantId") int id) {
        return merchantInventoryService.findByMerchantId(id);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @DeleteMapping(value = "/delete/{inventoryId}")
    public void deleteById(@PathVariable("inventoryId") int id) {
        //kafkaTemplate.send("product", findById(id));
        merchantInventoryService.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @PostMapping(value = "/add")
    public void save(@RequestBody MerchantInventory merchantInventory) throws JsonProcessingException {
        merchantInventoryService.save(merchantInventory);
    }


    @CrossOrigin(origins = "http://localhost:8082")
    @PostMapping(value = "/{inventoryId}/{price}")
    public void updatePrice(@PathVariable("inventoryId") int id, @PathVariable("price") double price) {
        merchantInventoryService.updatePrice(id, price);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping(value = "/{merchantId}/{productId}")
    public MerchantInventory findByMerchantIdAndProductId(@PathVariable("merchantId") int merchantId, @PathVariable("productId") int productId) {
        return merchantInventoryService.findByMerchantIdAndProductId(merchantId, productId);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping(value = "/brand/{brand}")
    public List<MerchantInventory> findByBrand(@PathVariable("brand") String brand) {
        return merchantInventoryService.findByBrand(brand);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping(value = "/merchants/{productId}")
    public List<MerchantIdAndPrice> findByProductId(@PathVariable("productId") int productId) {
        return merchantInventoryService.findByProductId(productId);
    }
}
