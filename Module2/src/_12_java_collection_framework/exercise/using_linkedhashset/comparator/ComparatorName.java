package _12_java_collection_framework.exercise.using_linkedhashset.comparator;

import _12_java_collection_framework.exercise.using_linkedhashset.Product;
import java.util.Comparator;

public class ComparatorName implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

