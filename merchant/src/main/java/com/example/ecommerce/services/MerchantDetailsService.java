package com.example.ecommerce.services;

import com.example.ecommerce.model.Merchant;

import java.util.List;

public interface MerchantDetailsService {
    Merchant save(Merchant merchant);
    Merchant findById(int id);
    List<Merchant> findAll();
}
