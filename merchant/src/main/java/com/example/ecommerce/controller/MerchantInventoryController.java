package com.example.ecommerce.controller;

import com.example.ecommerce.model.MerchantInventory;
import com.example.ecommerce.services.MerchantInventoryService;
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

    @GetMapping(value = "/{productId}")
    public MerchantInventory findById(@PathVariable("productId") int id) {
        return merchantInventoryService.findById(id);
    }

    @GetMapping(value = "/home/{merchantId}")
    public List<MerchantInventory> findByMerchantId(@PathVariable("merchantId") int id) {
        return merchantInventoryService.findByMerchantId(id);
    }

    @DeleteMapping(value = "/delete/{inventoryId}")
    public void deleteById(@PathVariable("inventoryId") int id) {
        //kafkaTemplate.send("product", findById(id));
        merchantInventoryService.deleteById(id);
    }

    @PostMapping(value = "/add")
    public void save(@RequestBody MerchantInventory merchantInventory) {
        merchantInventoryService.save(merchantInventory);
    }

    @PostMapping(value = "/{inventoryId}")
    public void updatePrice(@PathVariable("inventoryId") int id, double price) {
        merchantInventoryService.updatePrice(id, price);
    }

    @GetMapping(value = "/{merchantId}/{productId}")
    MerchantInventory findByMerchantIdAndProductId(@PathVariable("merchantId") int merchantId, @PathVariable("productId") int productId) {
        return merchantInventoryService.findByMerchantIdAndProductId(merchantId, productId);
    }
}
