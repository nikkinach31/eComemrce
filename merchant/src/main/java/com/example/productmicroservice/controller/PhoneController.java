package com.example.productmicroservice.controller;

import com.example.productmicroservice.entity.Phone;
import com.example.productmicroservice.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class PhoneController
{
    @Autowired
    PhoneService phoneService;

    @GetMapping(value = "/{productId}")
    Phone getByProductId(@PathVariable("productId") int id)
    {
        return phoneService.getByProductId(id);
    }

//    @PostMapping(value = "/addProd")
//    public void addProd(Phone newPhone)
//    {
//        LISTENER METHOD FOR PRODUCER IN MERCHANT TO ADD OBJECT
//    }



}
