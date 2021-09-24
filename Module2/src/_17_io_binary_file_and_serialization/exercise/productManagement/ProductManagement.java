package _17_io_binary_file_and_serialization.exercise.productManagement;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ProductManagement {
    static final String FILE_PATH = "src\\_17_io_binary_file_and_serialization\\exercise\\productManagement\\productFile.dat";
    static TreeSet<Product> products = ReadWrite.readDataFromFile(FILE_PATH);
    static Scanner scanner = new Scanner(System.in);

    public static TreeSet<Product> getProducts() {
        return products;
    }
    public static void display(){
        for (Product product:products) {
            System.out.println(product);
        }
    }

    public static void add(){
        System.out.println("Add new product");
        System.out.println("Enter productID");
        int productID = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter brand");
        String brand = scanner.nextLine();
        System.out.println("Enter price");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter descriptions");
        String descriptions = scanner.nextLine();
        Product product = new Product(productID,name,brand,price,descriptions);
        products.add(product);
        ReadWrite.writeToFile(FILE_PATH,products);
        display();
    }

    public static void remove(){
        System.out.println("Enter productID to remove");
        int productID = Integer.parseInt(scanner.nextLine());
        for (Product product:products) {
            if(productID==product.productId){
                products.remove(product);
                ReadWrite.writeToFile(FILE_PATH,products);
                return;
            }
        }
        System.out.println("Product is not found");
    }

    public static void search(){
        System.out.println("Enter productID");
        int productID = Integer.parseInt(scanner.nextLine());
        for (Product product:products) {
            if(productID==product.productId){
                System.out.println(product);
                return;
            }
        }
        System.out.println("Product is not found");
    }
}
