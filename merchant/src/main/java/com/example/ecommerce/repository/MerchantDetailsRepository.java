package com.example.ecommerce.repository;

import com.example.ecommerce.model.Merchant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantDetailsRepository extends CrudRepository<Merchant, Integer> {
}
