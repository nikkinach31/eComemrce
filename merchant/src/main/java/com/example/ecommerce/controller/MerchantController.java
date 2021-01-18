package com.example.ecommerce.controller;

import com.example.ecommerce.model.Merchant;
import com.example.ecommerce.services.MerchantDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/merchant/login")
public class MerchantController {

    @Autowired
    MerchantDetailsService merchantDetailsService;

    @GetMapping(value = "/{merchantId}")
    public Merchant findById(@PathVariable("merchantId") int id) {
        return merchantDetailsService.findById(id);
    }

    @GetMapping()
    public List<Merchant> findAll() {
        return merchantDetailsService.findAll();
    }

    @PostMapping(value = "/merchant/add")
    public Merchant save(@RequestBody Merchant merchant) {
        return merchantDetailsService.save(merchant);
    }
}
