package com.example.cartordermicroservice.repository;

import com.example.cartordermicroservice.entity.OrderDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Integer>
{
}
