package _12_java_collection_framework.exercise.using_arraylist_and_linkedlist.comparator;

import _12_java_collection_framework.exercise.using_arraylist_and_linkedlist.Product;

import java.util.Comparator;

public class ComparatorPriceHighToLow implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getPrice() - o1.getPrice();
    }
}
