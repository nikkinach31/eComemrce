package com.example.ecommerce.controller;

import com.example.ecommerce.model.MerchantStock;
import com.example.ecommerce.services.MerchantStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/merchant/stock")
public class MerchantStockController {

    @Autowired
    MerchantStockService merchantStockService;

    @GetMapping(value = "/{productId}")
    public MerchantStock findById(@PathVariable("productId") int productId) {
        return merchantStockService.findById(productId);
    }

    //don't need controller
    @DeleteMapping(value = "/{productId}")
    public void deleteById(@PathVariable("productId") int productId) {
        merchantStockService.deleteById(productId);
    }

    @PostMapping(value = "/update/{inventoryId}/{stock}")
    public void updateStock(@PathVariable("inventoryId") int inventoryInt, @PathVariable("stock") int stock) {
        merchantStockService.updateStock(inventoryInt, stock);
    }
}
