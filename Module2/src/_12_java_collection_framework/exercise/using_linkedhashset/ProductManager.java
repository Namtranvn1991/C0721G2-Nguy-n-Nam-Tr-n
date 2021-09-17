package _12_java_collection_framework.exercise.using_linkedhashset;

import _12_java_collection_framework.exercise.using_linkedhashset.comparator.ComparatorName;
import _12_java_collection_framework.exercise.using_linkedhashset.comparator.ComparatorPriceHighToLow;
import _12_java_collection_framework.exercise.using_linkedhashset.comparator.ComparatorPriceLowToHigh;

import java.util.*;

public class ProductManager {
    static Set<Product> set = new LinkedHashSet<>();
    private static Scanner scanner = new Scanner(System.in);

    static {
        set.add(new Product("Iphone13", 1299));
        set.add(new Product("Iphone12", 1399));
        set.add(new Product("Iphone11", 999));
        set.add(new Product("Iphone11", 999));
    }

    static void addProduct() {
        System.out.println("Enter product name");
        String name = scanner.nextLine();
        for (Product product : set) {
            if (product.getName().equals(name)) {
                System.out.println("Product " + name + " already exists");
                return;
            }
        }
        System.out.println("Enter price");
        int price = Integer.parseInt(scanner.nextLine());
        Product product = new Product(name, price);
        set.add(product);
    }

    static void remove() {
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        if (id > 0 && id <= set.size()) {
            int count = 1;
            for (Product product : set) {
                if (count == id) {
                    set.remove(product);
                    return;
                }
                count++;
            }
        }
    }

    static void edit() {
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        if (id > 0 && id <= set.size()) {
            System.out.println("1.Edit name 2.Edit price");
            int choice = Integer.parseInt(scanner.nextLine());
            int count = 1;
            for (Product product : set) {
                if (count == id) {
                    switch (choice) {
                        case 1:
                            System.out.println("Enter new name");
                            String name = scanner.nextLine();
                            product.setName(name);
                            break;
                        case 2:
                            System.out.println("Enter new price");
                            int price = Integer.parseInt(scanner.nextLine());
                            product.setPrice(price);
                            break;
                    }
                }
                count++;
            }
        }
    }

    static void search() {
        System.out.println("1.Search name 2.Search price");
        int choice = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        switch (choice) {
            case 1:
                System.out.println("Enter name");
                String name = scanner.nextLine();
                for (Product product : set) {
                    if (product.getName().equals(name)) {
                        System.out.println(product);
                        flag = true;
                    }
                }
                if (!flag){
                    System.out.println(name + " doesnt exist");
                }
                break;
            case 2:
                System.out.println("Enter price");
                int price = Integer.parseInt(scanner.nextLine());
                for (Product product : set) {
                    if (product.getPrice() == price) {
                        System.out.println(product);
                        flag = true;
                    }
                }
                if (!flag){
                    System.out.println(price + " doesnt exist");
                }
                break;
        }
    }

    static void sort(){
        System.out.println("1.Sort by name 2.Sort by price Low to High 3.Sort by price High to Low");
        int choice = Integer.parseInt(scanner.nextLine());
        ArrayList<Product> list = new ArrayList<>(set);
        switch (choice){
            case 1:
                ComparatorName comparatorName =new ComparatorName();
                Collections.sort(list,comparatorName);
                set = new LinkedHashSet<>(list);
                display();
                break;
            case 2:
                ComparatorPriceLowToHigh comparatorPriceLowToHigh = new ComparatorPriceLowToHigh();
                Collections.sort(list,comparatorPriceLowToHigh);
                set = new LinkedHashSet<>(list);
                display();
                break;
            case 3:
                ComparatorPriceHighToLow comparatorPriceHighToLow = new ComparatorPriceHighToLow();
                Collections.sort(list,comparatorPriceHighToLow);
                set = new LinkedHashSet<>(list);
                display();
                break;
        }
    }

    static void display() {
        int count = 1;
        for (Product product : set) {
            System.out.println(count + " - " + product);
            count++;
        }
    }
}
