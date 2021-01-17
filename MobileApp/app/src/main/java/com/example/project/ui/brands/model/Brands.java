package com.example.project.ui.brands.model;

public class Brands {
    private String name;
    private String imageUrl;
    private String bgColor;

    public Brands(String name, String imageUrl, String bgColor) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.bgColor = bgColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }
}
