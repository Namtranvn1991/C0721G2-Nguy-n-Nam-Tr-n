package _17_io_binary_file_and_serialization.exercise.product_management;

import java.io.Serializable;

public class Product implements Comparable<Product>, Serializable {
    int productId;
    String productName;
    String brand;
    int price;
    String descriptions;

    public Product() {
    }

    public Product(int productId, String productName, String brand, int price, String descriptions) {
        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.descriptions = descriptions;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", descriptions='" + descriptions + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return this.productId - o.productId;
    }
}
