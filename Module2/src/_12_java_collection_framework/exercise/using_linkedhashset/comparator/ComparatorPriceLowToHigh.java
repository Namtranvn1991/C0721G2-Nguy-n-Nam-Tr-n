package _12_java_collection_framework.exercise.using_linkedhashset.comparator;

import _12_java_collection_framework.exercise.using_linkedhashset.Product;

import java.util.Comparator;

public class ComparatorPriceLowToHigh implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
