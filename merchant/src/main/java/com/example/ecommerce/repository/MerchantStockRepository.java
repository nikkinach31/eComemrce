package com.example.ecommerce.repository;

import com.example.ecommerce.model.MerchantStock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantStockRepository extends CrudRepository<MerchantStock, Integer> {

    List<MerchantStock> findByOrderByItemsSoldDesc();
}
