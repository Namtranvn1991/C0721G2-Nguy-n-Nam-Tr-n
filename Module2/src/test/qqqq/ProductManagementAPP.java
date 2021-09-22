package test.qqqq;

import java.util.*;

class SortProductIncreaseByPrice implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}

class SortProductDecreaseByPrice implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o2.getPrice() - o1.getPrice());
    }
}

public class ProductManagementAPP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Iphone6", "Apple", 7000));
        productList.add(new Product("SonyXZ3", "Sony", 6000));
        productList.add(new Product("PassPort", "Blackberry", 5000));
        productList.add(new Product("Mi 8", "Xiaomi", 4000));
        int choose;
        do {
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display list product");
            System.out.println("5. Search product");
            System.out.println("6. Sort list product");
            System.out.println("0. Exit");
            System.out.println("You choose:");
            choose = Integer.parseInt(scanner.nextLine());
            if (choose == 1) {
                System.out.println("Input name :");
                String phone = scanner.nextLine();
                System.out.println("Input brand: ");
                String brand = scanner.nextLine();
                System.out.println("Input price: ");
                int price = Integer.parseInt(scanner.nextLine());
                productList.add(new Product(phone, brand, price));
                System.out.println("__________________________________");
            }
            if (choose == 2) {
                System.out.println("Input index of product: ");
                int number = Integer.parseInt(scanner.nextLine());
                System.out.println("Input name:");
                String phone = scanner.nextLine();
                System.out.println("Input brand: ");
                String brand = scanner.nextLine();
                System.out.println("Input price: ");
                int price = Integer.parseInt(scanner.nextLine());
                productList.get(number).setName(phone);
                productList.get(number).setBRAND(brand);
                productList.get(number).setPrice(price);
                System.out.println("__________________________________");
            }
            if (choose == 3) {
                System.out.println("Input index of product: ");
                int number = Integer.parseInt(scanner.nextLine());
                if (number >= productList.size()) {
                    System.out.println("Not found product");
                } else {
                    productList.remove(number);
                    System.out.println("Deleted: " + productList.get(number).getName());
                }
                System.out.println("__________________________________");
            }
            if (choose == 4) {
                for (Product Product : productList) {
                    System.out.println(Product);
                }
                System.out.println("__________________________________");
            }
            if (choose == 5) {
                System.out.println("Input name product to search: ");
                String phone = scanner.nextLine();
                for (Product Product : productList) {
                    if (Product.getName().equals(phone)) {
                        System.out.println(Product);
                    }
                }
                System.out.println("__________________________________");
            }
            if (choose == 6) {
                do {
                    System.out.println("1. Sap xep theo gia tang dan");
                    System.out.println("2. Sap xep theo gia giam dan");
                    System.out.println("0. Ket thuc");
                    choose = scanner.nextInt();
                    if (choose == 1) {
                        Collections.sort(productList, new SortProductDecreaseByPrice());
                    } else if (choose == 2) {
                        Collections.sort(productList, new SortProductIncreaseByPrice());
                    }
                    for (Product Product : productList) {
                        System.out.println(Product);
                    }
                } while (choose != 0);
            }
        } while (choose != 0);
    }
}
