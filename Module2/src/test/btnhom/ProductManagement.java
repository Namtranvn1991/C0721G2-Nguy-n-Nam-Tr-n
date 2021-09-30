package test.btnhom;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    private final String PATH_FILE = "src/exercise_04/product_data.dat";
    List<Product> productsList = readDataFromFile(PATH_FILE);
    Scanner sc = new Scanner(System.in);

    public void add() {
        System.out.print("Input id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Input name: ");
        String name = sc.nextLine();
        System.out.print("Input brand: ");
        String brand = sc.nextLine();
        System.out.println("Input price: ");
        int price = Integer.parseInt(sc.nextLine());
        Product product = new Product(id, name, brand, price);
        productsList.add(product);
        this.writeToFile(PATH_FILE, productsList);
    }

    public void findAll() {
        System.out.println("All list:");
        List<Product> productsListFile = this.readDataFromFile(PATH_FILE);
        for (Product product : productsListFile) {
            System.out.println(product);
        }
    }

    public void save(Product product) {
        productsList.add(product);
        this.writeToFile(PATH_FILE, productsList);
    }

    public Boolean find(String infor) {
        System.out.println("Find product " + infor);
        for (int i = 0; i < productsList.size(); i++) {
            if (infor.equals(String.valueOf(productsList.get(i).getId()))
                    || infor.equals(productsList.get(i).getName())
                    || infor.equals(productsList.get(i).getPrice())
                    || infor.equals(productsList.get(i).getBrand())
            ) {
                System.out.println(productsList.get(i));
                return true;
            }
        }
        System.out.println("Not found");
        return false;
    }

    public void writeToFile(String path, List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> readDataFromFile(String path) {
        List<Product> Products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (EOFException e) {
            System.out.println("Hahaha, loi roi :)");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return Products;
    }


}
