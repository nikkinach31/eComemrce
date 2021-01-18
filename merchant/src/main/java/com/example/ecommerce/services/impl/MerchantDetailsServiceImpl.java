package com.example.ecommerce.services.impl;

import com.example.ecommerce.model.Merchant;
import com.example.ecommerce.repository.MerchantDetailsRepository;
import com.example.ecommerce.services.MerchantDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantDetailsServiceImpl implements MerchantDetailsService {
    @Autowired
    MerchantDetailsRepository merchantDetailsRepository;

    @Override
    public Merchant save(Merchant merchant) {
        return merchantDetailsRepository.save(merchant);
    }

    @Override
    public Merchant findById(int id) {
        return merchantDetailsRepository.findById(id).get();
    }

    @Override
    public List<Merchant> findAll() {
        Iterable<Merchant> merchantIterable = merchantDetailsRepository.findAll();
        List<Merchant> merchantList = new ArrayList<>();
        merchantIterable.forEach(merchantList::add);
        return merchantList;
    }
}
