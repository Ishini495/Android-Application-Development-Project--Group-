package com.example.eommerce;

public class Product {
    private String productName;
    private String category1;
    private String type;

    private Double price;
    private String imgUrl;

    public Product() {

    }

    public Product(String productName, String category1, String type, Double price, String imgUrl) {
        this.productName = productName;
        this.category1 = category1;
        this.type = type;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory1() {
        return category1;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getType() {
        return type;
    }
}

