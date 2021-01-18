package com.example.product.controller;

import com.example.product.entity.Phone;
import com.example.product.service.PhoneService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PhoneController {
    @Autowired
    PhoneService phoneService;

    @GetMapping(value = "/{productId}")
    Phone findById(@PathVariable("productId") int id)
    {
        return phoneService.findById(id);
    }

    @GetMapping(value = "/homepage")
    public List<Phone> findProductByItemsSold() throws JsonProcessingException {
        return phoneService.findProductByItemsSold();
    }

    @GetMapping(value = "/brand/{brand}")
    public List<Phone> findProductByBrand(@PathVariable ("brand") String brand) {
        return phoneService.findProductByBrand(brand);
    }

    @PostMapping(value = "/rating/{id}/{rating}")
    public void updateRating(@PathVariable("id") int id, @PathVariable("rating") float rating) {
        phoneService.updateRating(id, rating);
    }
}
