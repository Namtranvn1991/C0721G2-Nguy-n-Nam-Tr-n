package com.codegym.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }


    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            if (itemEntry.getValue() > 9) {
                return;
            }
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    public void decreaseP(Product product) {
        Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
        if (itemEntry.getValue() < 1) {
            return;
        }
        Integer newQuantity = itemEntry.getValue() - 1;
        products.replace(itemEntry.getKey(), newQuantity);

    }

    public boolean setValue(Product product, Integer v){
        if(v<0||v>10){
            return false;
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            products.replace(itemEntry.getKey(), v);
            return true;
        }
    }

    public void removeProduct(Product product) {
        Product product1 = new Product();
        for (Product p : products.keySet()) {
            if (p.getId()==product.getId()) {
                product1 = p;
            }
        }
        products.remove(product1);
    }

    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}