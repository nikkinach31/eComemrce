package com.example.ecommerce.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "merchant_stock")
public class MerchantStock implements Serializable {
    @Id
    private int inventoryId;

    private int productId;
    private int stock;
    private int itemsSold;

    public MerchantStock() {
    }

    @Autowired
    public MerchantStock(int inventoryId, int productId, int quantity) {
        this.inventoryId = inventoryId;
        this.productId = productId;
        this.stock = quantity;
        this.itemsSold = 0;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getItemsSold() {
        return itemsSold;
    }

    public void setItemsSold(int itemsSold) {
        this.itemsSold = itemsSold;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
