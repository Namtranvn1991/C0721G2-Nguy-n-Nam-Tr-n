package repository.impl;

import beam.Product;
import repository.IProductRepository;

import java.util.*;

public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new TreeMap<>();
        productMap.put(1,new Product(1,"Iphone11",1000,"black","Apple"));
        productMap.put(2,new Product(2,"Iphone12",1200,"pink","Apple"));
        productMap.put(3,new Product(3,"S10",1000,"black","Samsung"));
        productMap.put(4,new Product(4,"H11",999,"blue","Huawei"));
        productMap.put(5,new Product(5,"N12",500,"red","Nokia"));
    }


    @Override
    public List<Product> findAll() {
        return new LinkedList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);

    }

    @Override
    public Product findByID(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> listAll = findAll();
        List<Product> searchList = new ArrayList<>();
        for (Product product:listAll) {
            if(product.getName().toLowerCase().contains(name)){
                searchList.add(product);
            }
        }
        if(searchList.isEmpty()){
            return null;
        } else {
            return searchList;
        }
    }

    public static void main(String[] args) {

        productMap.put(1,new Product(1,"123",123,"321","123"));
        productMap.forEach((k, v)-> System.out.println(v));

    }
}
