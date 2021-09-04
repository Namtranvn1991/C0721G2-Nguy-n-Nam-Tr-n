package _4_class_and_object_in_java.practice;

import java.util.Scanner;

public class TestClassRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the width:");
        double width = scanner.nextDouble();
        System.out.print("Enter the height:");
        double height = scanner.nextDouble();

        Rectangle rectangle1 = new Rectangle(width,height);
        System.out.println(rectangle1.display());
        System.out.printf("Area of rectangle with width %s and height %s is %s \n", rectangle1.width,rectangle1.height,rectangle1.getArea());
        rectangle1.draw();


    }
}
class Rectangle{
    double width;
    double height;
    Rectangle(){
        width = 0;
        height =0;
    }
    Rectangle(double width,double height){
        this.width = width;
        this.height = height;
    }

    double getArea(){
        return this.width*this.height;
    }
    double getPerimeter(){
        return (this.width+this.height)*2;
    }

    String display(){
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }

    void draw(){
        for (int i=0; i<this.height;i++){
            for (int j=0; j<this.width;j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

}
