package com.example.productmicroservice.repository;

import com.example.productmicroservice.entity.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Phone, Integer>
{

}
