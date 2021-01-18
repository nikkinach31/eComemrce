package com.example.ecommerce.model;

public class MerchantIdAndPrice {
    private int merchantId;
    private double price;

    public MerchantIdAndPrice(int merchantId, double price) {
        this.merchantId = merchantId;
        this.price = price;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
