package com.example.product.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MerchantStockList implements Serializable {
    private List<MerchantStock> merchantStocks;

    public MerchantStockList() {
        merchantStocks = new ArrayList<>();
    }

    public List<MerchantStock> getMerchantStocks() {
        return merchantStocks;
    }

    public void setMerchantStocks(List<MerchantStock> merchantStocks) {
        this.merchantStocks = merchantStocks;
    }
}
