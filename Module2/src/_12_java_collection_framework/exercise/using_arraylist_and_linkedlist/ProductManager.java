package _12_java_collection_framework.exercise.using_arraylist_and_linkedlist;

import _12_java_collection_framework.exercise.using_arraylist_and_linkedlist.comparator.ComparatorName;
import _12_java_collection_framework.exercise.using_arraylist_and_linkedlist.comparator.ComparatorPriceHighToLow;
import _12_java_collection_framework.exercise.using_arraylist_and_linkedlist.comparator.ComparatorPriceLowToHigh;

import java.util.*;

public class ProductManager {
    static List<Product> arrList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    static {
        arrList.add(new Product("Iphone13", 1299));
        arrList.add(new Product("Iphone12", 1399));
        arrList.add(new Product("Iphone11", 999));
        arrList.add(new Product("Iphone11", 999));
    }

    static void addProduct() {
        System.out.println("Enter product name");
        String name = scanner.nextLine();
        for (Product product : arrList) {
            if (product.getName().equals(name)) {
                System.out.println("Product " + name + " already exists");
                return;
            }
        }
        System.out.println("Enter price");
        int price = Integer.parseInt(scanner.nextLine());
        Product product = new Product(name, price);
        arrList.add(product);
        display();
    }

    static void remove() {
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        if (id > 0 && id <= arrList.size()) {
            arrList.remove(arrList.get(id - 1));
        }
        display();
    }

    static void edit() {
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        int index = id-1;
        if (id > 0 && id <= arrList.size()) {
            System.out.println("1.Edit name 2.Edit price");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter new name");
                    String name = scanner.nextLine();
                    arrList.get(index).setName(name);
                    break;
                case 2:
                    System.out.println("Enter new price");
                    int price = Integer.parseInt(scanner.nextLine());
                    arrList.get(index).setPrice(price);
                    break;
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
                for (Product product : arrList) {
                    if (product.getName().contains(name)) {
                        System.out.println(product);
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println(name + " doesnt exist");
                }
                break;
            case 2:
                System.out.println("Enter price");
                int price = Integer.parseInt(scanner.nextLine());
                for (Product product : arrList) {
                    if (product.getPrice() == price) {
                        System.out.println(product);
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println(price + " doesnt exist");
                }
                break;
        }
    }

    static void sort() {
        System.out.println("1.Sort by name 2.Sort by price Low to High 3.Sort by price High to Low");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                Collections.sort(arrList, new ComparatorName());
                display();
                break;
            case 2:
                Collections.sort(arrList, new ComparatorPriceLowToHigh());
                display();
                break;
            case 3:
                Collections.sort(arrList, new ComparatorPriceHighToLow());
                display();
                break;
        }
    }

    static void display() {
        int count = 1;
        for (Product product : arrList) {
            System.out.println(count + " - " + product);
            count++;
        }
    }
}
