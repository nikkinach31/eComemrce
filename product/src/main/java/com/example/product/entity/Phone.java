package com.example.product.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Phone {
    @Id
    private int productId;
    private String name;
    private String brand;
    private String modelName;
    private String camera;
    private String color;
    private  String memory;

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getModelName()
    {
        return modelName;
    }

    public void setModelName(String modelName)
    {
        this.modelName = modelName;
    }

    public String getCamera()
    {
        return camera;
    }

    public void setCamera(String camera)
    {
        this.camera = camera;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getMemory()
    {
        return memory;
    }

    public void setMemory(String memory)
    {
        this.memory = memory;
    }
}
