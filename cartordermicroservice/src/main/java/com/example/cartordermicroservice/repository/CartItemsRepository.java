package com.example.cartordermicroservice.repository;

import com.example.cartordermicroservice.entity.CartItems;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepository extends CrudRepository<CartItems, Integer>
{
    @Modifying
    @Query(value = "update cartitems set quantity = :quantity where item_id = :id ", nativeQuery = true)
    void updateQuantity(@Param("quantity") int quantity, @Param("id") int id);
}
