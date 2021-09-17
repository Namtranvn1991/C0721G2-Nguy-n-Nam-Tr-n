package _12_java_collection_framework.exercise.using_linkedhashset.comparator;

import _12_java_collection_framework.exercise.using_linkedhashset.Product;

import java.util.Comparator;

public class ComparatorPriceHighToLow implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getPrice() - o1.getPrice();
    }
}
