package com.example.ecommerce.repository;

import com.example.ecommerce.model.MerchantInventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantInventoryRepository extends CrudRepository<MerchantInventory, Integer> {

    List<MerchantInventory> findByMerchantId(int merchantId);
    MerchantInventory findByMerchantIdAndProductId(int merchantId, int productId);

}
