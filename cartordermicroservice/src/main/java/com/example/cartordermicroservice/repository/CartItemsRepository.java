package com.example.cartordermicroservice.repository;

import com.example.cartordermicroservice.entity.CartItems;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepository extends CrudRepository<CartItems, Integer>
{

}
