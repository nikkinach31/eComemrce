package com.example.ecommerce.controller;

import com.example.ecommerce.model.Merchant;
import com.example.ecommerce.model.MerchantStock;
import com.example.ecommerce.services.MerchantStockService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/merchant/stock")
public class MerchantStockController {

    @Autowired
    MerchantStockService merchantStockService;

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping(value = "/{productId}")
    public MerchantStock findById(@PathVariable("productId") int productId) {
        return merchantStockService.findById(productId);
    }

    //don't need controller
    @CrossOrigin(origins = "http://localhost:8082")
    @DeleteMapping(value = "/{productId}")
    public void deleteById(@PathVariable("productId") int productId) {
        merchantStockService.deleteById(productId);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @PostMapping(value = "/updatestock/{inventoryId}/{stock}")
    public void updateStock(@PathVariable("inventoryId") int inventoryId, @PathVariable("stock") int stock) {
        merchantStockService.updateStock(inventoryId, stock);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @PostMapping(value = "/update/itemssold/{inventoryId}/{itemsSold}")
    public void updateItemsSold(@PathVariable("inventoryId") int inventoryId, @PathVariable("itemsSold") int itemsSold) {
        merchantStockService.updateItemsSold(inventoryId, itemsSold);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping(value = "/stock/{inventoryId}")
    public int findStockById(@PathVariable("inventoryId") int id) {
        return merchantStockService.findStockById(id);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping(value = "/sort")
    public List<MerchantStock> findByOrderByItemsSoldDesc() throws JsonProcessingException {
        return merchantStockService.findByOrderByItemsSoldDesc();
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping(value = "/{merchantId}/{productId}")
    public int findStockByMerchantIdAndProductId(@PathVariable("merchantId") int merchantId, @PathVariable("productId") int productId) {
        return merchantStockService.findStockByMerchantIdAndProductId(merchantId, productId);
    }
}
