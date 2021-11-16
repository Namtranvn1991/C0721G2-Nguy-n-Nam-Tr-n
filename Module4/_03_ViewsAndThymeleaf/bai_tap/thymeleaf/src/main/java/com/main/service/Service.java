package com.main.service;

import com.main.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service implements IService {

    private static Map<Integer,Product> list = new HashMap<>();

    static {
        list.put(1,new Product(1,"iphone5","apple",999,"black"));
        list.put(2,new Product(2,"iphone9","apple",1111,"pink"));
        list.put(3,new Product(3,"note4","ss",555,"blue"));
        list.put(4,new Product(4,"nokia5","nokia",333,"white"));
        list.put(5,new Product(5,"X","sony",999,"black"));

    }

    @Override
    public void add(Product product) {
        list.put(product.getId(),product);
    }

    @Override
    public void edit(Product product) {
        list.put(product.getId(),product);
    }

    @Override
    public void delete(Integer id) {
        list.remove(id);
    }

    @Override
    public List<Product> allProduct() {
        List<Product> productList = new ArrayList<Product>(list.values());
        return productList;
    }

    @Override
    public Product findById(Integer id) {
        return list.get(id);
    }
}
