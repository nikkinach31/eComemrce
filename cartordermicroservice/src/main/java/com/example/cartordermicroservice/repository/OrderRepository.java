package com.example.cartordermicroservice.repository;

import com.example.cartordermicroservice.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>
{

}
