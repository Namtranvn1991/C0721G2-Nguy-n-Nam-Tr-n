package com.main.service;

import com.main.model.Product;

import java.util.List;

public interface IService {

    public void add(Product product);

    public void edit(Product product);

    public void delete(Integer id);

    public List<Product> allProduct ();

    public Product findById(Integer id);

}
