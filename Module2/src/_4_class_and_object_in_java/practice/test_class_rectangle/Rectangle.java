package _4_class_and_object_in_java.practice.test_class_rectangle;

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
