package com.example.product.repository;

import com.example.product.entity.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Phone, Integer> {
        List<Phone> findByBrand(String brand);
}
