package com.example.product.controller;

import com.example.product.entity.Phone;
import com.example.product.entity.PhoneHomepage;
import com.example.product.service.PhoneService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class PhoneController {
    @Autowired
    PhoneService phoneService;

    @GetMapping(value = "/{productId}")
    Phone getByProductId(@PathVariable("productId") int id)
    {
        return phoneService.getByProductId(id);
    }

    @GetMapping(value = "/homepage")
    public List<PhoneHomepage> findProductByItemsSold() throws JsonProcessingException {
        return phoneService.findProductByItemsSold();
    }
}
