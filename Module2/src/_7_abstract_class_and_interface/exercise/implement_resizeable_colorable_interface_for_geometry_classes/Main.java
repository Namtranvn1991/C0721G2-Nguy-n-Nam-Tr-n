package _7_abstract_class_and_interface.exercise.implement_resizeable_colorable_interface_for_geometry_classes;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[6];
        Circle circle= new Circle(2);
        shapes[0] = new Circle(2,"blue",true);
        shapes[1] = new Circle(4,"red",true);
        shapes[2] = new Rectangle(2,4,"green",false);
        shapes[3] = new Square(3,"white",true);
        shapes[4] = new Rectangle(3,4,"black",true);
        shapes[5] = circle;

        for (int i = 0; i < shapes.length ; i++) {
            double random = Math.random()*200+1;
            shapes[i].resizeItself(random);
            System.out.println(shapes[i]);
            if (shapes[i] instanceof Colorable){
                ((Colorable) shapes[i]).howToColor();
            }
        }
    }
}
