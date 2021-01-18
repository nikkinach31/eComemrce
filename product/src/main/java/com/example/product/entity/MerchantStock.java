package com.example.product.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class MerchantStock {
    private int inventoryId;

    private int productId;
    private int stock;
    private int itemsSold;

    public MerchantStock() {
    }

    public MerchantStock(int inventoryId, int quantity) {
        this.inventoryId = inventoryId;
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
