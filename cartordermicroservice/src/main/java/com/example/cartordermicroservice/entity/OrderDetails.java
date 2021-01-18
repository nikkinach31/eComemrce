package com.example.cartordermicroservice.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "customer_order_detail")
public class OrderDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int oderIdDet;

    private int productId;
    private String productName;
    private int merchantId;
    private double price;
    private int quantity;


    public int getOderIdDet()
    {
        return oderIdDet;
    }

    public void setOderIdDet(int oderIdDet)
    {
        this.oderIdDet = oderIdDet;
    }

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public int getMerchantId()
    {
        return merchantId;
    }

    public void setMerchantId(int merchantId)
    {
        this.merchantId = merchantId;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
}
